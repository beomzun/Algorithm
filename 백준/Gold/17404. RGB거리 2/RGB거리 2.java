import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            dp[1][0] = house[1][0] + house[0][i];
            dp[1][1] = house[1][1] + house[0][i];
            dp[1][2] = house[1][2] + house[0][i];
            dp[1][i] = 1_000_001;
            for (int j = 2; j < N - 1; j++) {
                dp[j][0] = house[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
                dp[j][1] = house[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
                dp[j][2] = house[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
            }
            dp[N-1][0] = house[N-1][0] + Math.min(dp[N - 2][1], dp[N - 2][2]);
            dp[N-1][1] = house[N-1][1] + Math.min(dp[N - 2][0], dp[N - 2][2]);
            dp[N-1][2] = house[N-1][2] + Math.min(dp[N - 2][0], dp[N - 2][1]);
            dp[N-1][i] = 1_000_001;
            min = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), Math.min(dp[N - 1][2], min));
        }

        System.out.println(min);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
