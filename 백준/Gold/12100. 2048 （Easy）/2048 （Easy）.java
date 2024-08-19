import java.util.*;
import java.io.*;

class Solution {
    static int max = 0;
    static int n;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        swipe(board, 0);

        System.out.println(max);
    }

    public void swipe(int[][] now, int count) {
        if (count == 5) {
            findMax(now);
            return;
        }

        up(now, count);
        down(now, count);
        right(now, count);
        left(now, count);
    }

    public void up(int[][] now, int count) {
        int[][] next = copyBoard(now);

        //각 열별
        for (int i = 0; i < n; i++) {
            int target = 0;
            //각 행별
            for (int j = 0; j <= n - 1; j++) {
                if (next[j][i] == 0) {
                    continue;
                }

                boolean is = false;
                //짝 찾기
                for (int k = j + 1; k <= n - 1; k++) {
                    //짝이 아니고, 다른 수가 껴있어서 합쳐질수 없다면
                    if (next[k][i] != next[j][i] && next[k][i] != 0) {
                        break;
                    }
                    //짝이라면
                    if (next[k][i] == next[j][i]) {
                        int tmp = next[j][i];
                        next[j][i] = next[k][i] = 0;
                        next[target++][i] = 2 * tmp;
                        is = true;
                        break;
                    }
                }
                //짝이 없다면
                if (!is) {
                    int tmp = next[j][i];
                    next[j][i] = 0;
                    next[target++][i] = tmp;
                }
            }
        }
        swipe(next, count + 1);
    }
    public void down(int[][] now, int count) {
        int[][] next = copyBoard(now);

        //각 열별
        for (int i = 0; i < n; i++) {
            int target = n-1;
            //각 행별
            for (int j = n - 1; j >= 0; j--) {
                if (next[j][i] == 0) {
                    continue;
                }

                boolean is = false;
                for (int k = j - 1; k >= 0; k--) {
                    if (next[k][i] != next[j][i] && next[k][i] != 0) {
                        break;
                    }
                    if (next[j][i] == next[k][i]) {
                        int tmp = next[j][i];
                        next[j][i] = next[k][i] = 0;
                        next[target--][i] = 2 * tmp;
                        is = true;
                        break;
                    }
                }
                if (!is) {
                    int tmp = next[j][i];
                    next[j][i] = 0;
                    next[target--][i] = tmp;
                }
            }
        }
        swipe(next, count + 1);
    }
    public void right(int[][] now, int count) {
        int[][] next = copyBoard(now);

        //각 행별
        for (int i = 0; i < n; i++) {
            int target = n - 1;
            //각 열별
            for (int j = n - 1; j >= 0; j--) {
                if (next[i][j] == 0) {
                    continue;
                }

                boolean is = false;
                for (int k = j - 1; k >= 0; k--) {
                    if (next[i][k] != next[i][j] && next[i][k] != 0) {
                        break;
                    }
                    if (next[i][j] == next[i][k]) {
                        int tmp = next[i][j];
                        next[i][j] = next[i][k] = 0;
                        next[i][target--] = 2 * tmp;
                        is = true;
                        break;
                    }
                }
                if (!is) {
                    int tmp = next[i][j];
                    next[i][j] = 0;
                    next[i][target--] = tmp;
                }
            }
        }
        swipe(next, count + 1);
    }
    public void left(int[][] now, int count) {
        int[][] next = copyBoard(now);

        for (int i = 0; i < n; i++) {
            int target = 0;
            for (int j = 0; j <= n - 1; j++) {
                if (next[i][j] == 0) {
                    continue;
                }

                boolean is = false;
                for (int k = j + 1; k <= n - 1; k++) {
                    if (next[i][k] != next[i][j] && next[i][k] != 0) {
                        break;
                    }
                    if (next[i][j] == next[i][k]) {
                        int tmp = next[i][j];
                        next[i][j] = next[i][k] = 0;
                        next[i][target++] = 2 * tmp;
                        is = true;
                        break;
                    }
                }
                if (!is) {
                    int tmp = next[i][j];
                    next[i][j] = 0;
                    next[i][target++] = tmp;
                }
            }
        }
        swipe(next, count + 1);
    }

    public int[][] copyBoard(int[][] now) {
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = now[i][j];
            }
        }

        return next;
    }

    public void findMax(int[][] now) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, now[i][j]);
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
첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다.
0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다. 블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.

과정
이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다.
이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다.
한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다.
똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다.

출력
최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.

해결
이동하려고 하는 쪽의 첫 인덱스부터 반대쪽으로 탐색하였음 -> 합쳐지는 순서 고려
짝을 찾은 경우 / 짝이 끝까지 없는 경우 / 중간에 다른 수가 존재하여 합쳐지지 못하는 경우 로 나눠서 풀이함
target 인덱스를 활용하여 수를 배치하였음
 */