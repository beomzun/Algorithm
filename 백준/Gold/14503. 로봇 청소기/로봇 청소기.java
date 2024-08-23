import java.util.*;
import java.io.*;

class Solution {
    static int count = 0;
    static int[][] room;
    static int row;
    static int col;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        room = new int[row][col];

        st = new StringTokenizer(br.readLine());
        int start_row = Integer.parseInt(st.nextToken());
        int start_col = Integer.parseInt(st.nextToken());
        int start_dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(start_row, start_col, start_dir);
        System.out.println(count);
    }

    public void clean(int y, int x, int dir) {
        if (room[y][x] == 0) {
            room[y][x] = -1;
            count++;
        }

        int i = 3;
        int nextDir, nextY, nextX;

        //청소되지 않은 곳이 있다면
        for (; i >= 0; i--) {
            nextDir = (dir + i) % 4;
            nextY = y + dy[nextDir];
            nextX = x + dx[nextDir];

            if (nextY < 0 || nextY >= row || nextX < 0 || nextX >= col) {
                continue;
            }
            if (room[nextY][nextX] == 0) {
                clean(nextY, nextX, nextDir);
                return;
            }
        }
        //청소되지 않은곳이 없다면
        if (i == -1) {
            nextDir = (dir + 2) % 4;
            nextY = y + dy[nextDir];
            nextX = x + dx[nextDir];

            if (nextY < 0 || nextY >= row || nextX < 0 || nextX >= col || room[nextY][nextX] == 1) {
                return;
            }

            clean(nextY, nextX, dir);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
반시계 방향으로 회전한다고 해서 북서남동으로 dy,dx를 조절했으나 문제에서 북동남서로 고정하였기에 틀렸음
 */