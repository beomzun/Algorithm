import java.util.*;
import java.io.*;

class Solution {
    static int row;
    static int col;
    static int n;
    static int[][] map;
    static int[] comm;
    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int start_y = Integer.parseInt(st.nextToken());
        int start_x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comm = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            comm[i] = Integer.parseInt(st.nextToken());
        }

        move(start_x, start_y, 0);

        bw.flush();
        bw.close();
    }

    public void move(int x, int y, int commIdx) throws IOException {
        if (commIdx == n) {
            return;
        }
        int nextX = x;
        int nextY = y;
        switch (comm[commIdx]) {
            case 1:
                if (roll(x + 1, nextY, 1)) {
                    nextX = x + 1;
                    paste(nextX, nextY);
                }
                break;
            case 2:
                if (roll(x - 1, nextY, 2)) {
                    nextX = x - 1;
                    paste(nextX, nextY);
                }
                break;
            case 3:
                if (roll(nextX, y - 1, 3)) {
                    nextY = y - 1;
                    paste(nextX, nextY);
                }
                break;
            case 4:
                if (roll(nextX, y + 1, 4)) {
                    nextY = y + 1;
                    paste(nextX, nextY);
                }
                break;
        }

        move(nextX, nextY, commIdx + 1);
    }

    public boolean roll(int x, int y, int dir) {
        if (x < 0 || x >= col || y < 0 || y >= row) {
            return false;
        }

        int tmp;
        switch (dir) {
            case 1:
                tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            case 2:
                tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                tmp = dice[1];
                dice[1]=dice[5];
                dice[5]=dice[6];
                dice[6]=dice[2];
                dice[2] = tmp;
                break;
            case 4:
                tmp = dice[1];
                dice[1] = dice[2];
                dice[2]=dice[6];
                dice[6]=dice[5];
                dice[5] = tmp;
                break;
        }
        return true;
    }

    public void paste(int x, int y) throws IOException {
        if (map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
        bw.write(dice[1] + "\n");
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
입력
첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20), 주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1), 그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.
둘째 줄부터 N개의 줄에 지도에 쓰여 있는 수가 북쪽부터 남쪽으로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다.
주사위를 놓은 칸에 쓰여 있는 수는 항상 0이다. 지도의 각 칸에 쓰여 있는 수는 10 미만의 자연수 또는 0이다.
마지막 줄에는 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.

과정
주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x, y) 이다. 가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
지도의 각 칸에는 정수가 하나씩 쓰여져 있다.
주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.
주사위는 지도의 바깥으로 이동시킬 수 없다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.

출력
이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다.

해결
그냥 구현..
---
roll 메서드의 결과 이전에 다음 지도 위치를 반영했어서 오답.
---
x,y 받는 순서,,
 */