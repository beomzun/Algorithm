import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int K = Integer.parseInt(br.readLine());
            int[] sum = new int[K+1];
            int[][] dp = new int[K+1][K+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=K;i++) {
                int val = Integer.parseInt(st.nextToken());
                sum[i] += sum[i - 1] + val;
            }

            for (int i = 1; i < K; i++) {
                for (int start = 1; start + i <= K; start++) {
                    int end = start + i;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][mid] + dp[mid + 1][end]);
                    }
                    dp[start][end] += (sum[end] - sum[start - 1]);
                }
            }

            sb.append(dp[1][K]).append("\n");
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
0~K까지 합치는 최소값
0~i,i+1~K로 분리 (i=0~k)
 */