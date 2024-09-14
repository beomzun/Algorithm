import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int M;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] now = new boolean[N][M];
        boolean[][] end = new boolean[N][M];
        Set<String> visit = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                now[i][j] = Character.getNumericValue(s.charAt(j)) > 0;
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                end[i][j] = Character.getNumericValue(s.charAt(j)) > 0;
            }
        }

        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (now[i][j] != end[i][j] && i + 2 < N && j + 2 < M) {
                    reverse(now, i, j);
                    time++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (now[i][j] != end[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(time);
    }

    public void reverse(boolean[][] tmp, int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                tmp[i][j] = !tmp[i][j];
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
bfs 과정에서 새 배열 대신, dfs 원본 수정 느낌으로
---
다른 경우만 바꾸자
 */