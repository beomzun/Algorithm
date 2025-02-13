import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 9901;
        int[][] dp = new int[N+1][3];
        dp[1][0]=dp[1][1]=dp[1][2]=1;
        for(int i=2;i<=N;i++) {
            dp[i][0] = dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
            dp[i][0]%=mod;
            dp[i][1] = dp[i-1][0]+dp[i-1][2];
            dp[i][1]%=mod;
            dp[i][2] = dp[i-1][0]+dp[i-1][1];
            dp[i][2]%=mod;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % mod);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}