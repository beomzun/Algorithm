import java.util.*;
class Solution {
    public int solution(int M, int N, int[][] puddles) {
        int mod = 1_000_000_007;
        int[][] counts = new int[N][M];
        for(int i=0;i<puddles.length;i++) {
            counts[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        counts[0][0]=1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if((i==0&&j==0) || counts[i][j]==-1) {
                    continue;
                }
                int up=0;
                if(i>0 && counts[i-1][j]!=-1) {
                    up = counts[i-1][j];
                }
                int left=0;
                if(j>0 && counts[i][j-1]!=-1) {
                    left = counts[i][j-1];
                }
                counts[i][j] = (up+left)%mod;
            }
        }
        
        return counts[N-1][M-1];
    }
}
/*
n이 행.
집은 1,1 -> 배열크기 +1씩
*/