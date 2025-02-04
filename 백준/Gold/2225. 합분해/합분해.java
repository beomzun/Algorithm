import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        int mod = 1_000_000_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1);
        for(int i=2;i<=K;i++) {
            dp[i][0] = 1;
            for(int j=1;j<=N;j++) {
                for(int k=0;k<=j;k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j]%=mod;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}