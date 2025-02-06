import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[31];
        dp[0]=dp[1]=1;
        dp[2] = 2;
        for(int i=3;i<=30;i++) {
            for(int j=0;j<i;j++) {
                dp[i] += dp[i - 1 - j] * dp[j];
            }
        }
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0) {
                break;
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
큰
1

작 큰 dp0*dp1
큰 작 dp1*dp0
dp[2] =

작 큰 큰 -> dp2*dp0
큰 큰 작 -> dp2*dp0
큰 작 큰 -> dp1*dp1
dp3 = 2dp2*dp0 + dp1*dp1

큰 큰 큰 작 -> dp3
큰 큰 작 큰 -> dp2*dp1
큰 작 큰 큰 -> dp1*dp2
작 큰 큰 큰 -> dp3
dp4 = 2dp3*dp0 + 2dp1*dp2

dp4+dp3*1+dp2*2+dp1*dp3+dp4
 */
