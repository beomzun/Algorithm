import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N-1][21];
        dp[0][arr[0]]=1;
        for(int i=1;i<N-1;i++) {
            for(int j=0;j<=20;j++) {
                if(dp[i-1][j]==0) {
                    continue;
                }
                int val = j+arr[i];
                if(val>=0&&val<=20) {
                    dp[i][val] += dp[i - 1][j];
                }

                val = j-arr[i];
                if(val>=0&&val<=20) {
                    dp[i][val] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N-2][arr[N-1]]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
2차원 dp. 각 행이 i번째 값이고, 열이 계산했을때 가능한 경우의 수 
 */