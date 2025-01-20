import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int less = (int)Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = less; j > 0; j--) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[N]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
18일 때 4,3,2,1 중 가장 작은수 +1
 */