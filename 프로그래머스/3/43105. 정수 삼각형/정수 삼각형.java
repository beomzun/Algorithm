import java.util.*;
class Solution {
    public int solution(int[][] tri) {
        int N = tri.length;
        int[][] dp = new int[N][N];
        dp[0][0]=tri[0][0];
        for(int i=1;i<N;i++) {
            for(int j=0;j<=i;j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][0]+tri[i][0];
                } else if(j==i) {
                    dp[i][j] = dp[i-1][i-1]+tri[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+tri[i][j];
                }
            }
        }
        int max = 0;
        for(int i=0;i<N;i++) {
            max = Math.max(dp[N-1][i],max);
        }
        return max;
    }
}