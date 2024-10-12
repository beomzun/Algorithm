import java.util.*;
import java.io.*;
class Solution {
    static int[][] map;
    static int[][] dp;
    static boolean[][] visit;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int R;
    static int C;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dp = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[R - 1][C - 1] = 1;
        visit[R - 1][C - 1] = true;
        System.out.println(dfs(0, 0));
    }
    public int dfs(int y, int x) {
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];
            if (nY < 0 || nY >= R || nX < 0 || nX >= C) {
                continue;
            }
            if (map[y][x] > map[nY][nX]) {
                if (!visit[nY][nX]) {
                    dp[y][x] += dfs(nY, nX);
                } else {
                    dp[y][x] += dp[nY][nX];
                }
            }
        }
        return dp[y][x];
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
dfs 로 접근하고, dp로 값 저장
 */