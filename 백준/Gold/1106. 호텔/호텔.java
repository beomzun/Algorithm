import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C+1];
        Arrays.fill(dp,1_000_001);
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for(;customer<=C;customer*=2, price*=2) {
                dp[customer] = Math.min(dp[customer], price);
            }
            dp[C]=Math.min(dp[C],price);
        }
        int min = dp[C];
        for(int i=C-1;i>0;i--) {
            dp[i] = Math.min(dp[i],min);
            min = Math.min(min, dp[i]);
        }
        for(int i=2;i<=C;i++) {
            for(int j=1;j<=i/2;j++) {
                dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
            }
        }
        System.out.println(dp[C]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
C명을 위한 최소금액 -> C명이 기준인지
 */