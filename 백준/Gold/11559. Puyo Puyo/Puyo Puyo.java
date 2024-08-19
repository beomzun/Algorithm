import java.util.*;
import java.io.*;

class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visit = new boolean[12][6];
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static char[][] puyo = new char[12][6];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                puyo[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        while (true) {
            boolean isBomb = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (puyo[i][j] != '.' && !visit[i][j]) {
                        find(i,j, puyo[i][j]);
                        if (queue.size() >= 4) {
                            bomb();
                            isBomb = true;
                            continue;
                        }
                        clear();
                    }
                }
            }
            drop();
            if (!isBomb) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }

    public void find(int row, int col, char val) {
        int[] tmp = {row, col};
        visit[row][col] = true;
        queue.add(tmp);

        for (int i = 0; i < 4; i++) {
            int nowY = row + dy[i];
            int nowX = col + dx[i];
            if (nowY < 0 || nowY >= 12 || nowX < 0 || nowX >= 6) {
                continue;
            }
            if (puyo[nowY][nowX] == val && !visit[nowY][nowX]) {
                find(nowY, nowX, val);
            }
        }
    }

    public void clear() {
        while(!queue.isEmpty()) {
            int[] tmp = queue.remove();
            visit[tmp[0]][tmp[1]] = false;
        }
    }
    public void bomb() {
        while(!queue.isEmpty()) {
            int[] tmp = queue.remove();
            visit[tmp[0]][tmp[1]] = false;
            puyo[tmp[0]][tmp[1]] = '.';
        }
    }

    public void drop() {
        for (int i = 0; i < 6; i++) {
            int index = 11;
            for (int j = 11; j >= 0; j--) {
                if (puyo[j][i] != '.') {
                    char tmp = puyo[j][i];
                    puyo[j][i] = '.';
                    puyo[index--][i] = tmp;
                }
            }
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
입력
총 12개의 줄에 필드의 정보가 주어지며, 각 줄에는 6개의 문자가 있다.
이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.
R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태이다. 즉, 뿌요 아래에 빈 칸이 있는 경우는 없다.

과정
필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다. 이때 1연쇄가 시작된다.
뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.
아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.
터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.
=> 테트리스임. 터지는 횟수가 아니라 터질수있는 상황이 몇번인지?

출력
현재 주어진 상황에서 몇연쇄가 되는지 출력한다. 하나도 터지지 않는다면 0을 출력한다.

해결
뿌요 풀스캔 후 각 상황에 이어진게 4개 이상이라면 터트리기. 4개 이하라면 방문초기화
전체 탐색 후 마지막에 떨구기 진행.
한 번이라도 터졌다면 위 과정 반복.
 */