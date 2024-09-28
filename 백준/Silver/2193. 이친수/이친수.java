import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        long[][] dp = new long[2][N];
        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < N; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
        }
        System.out.println(dp[0][N - 1] + dp[1][N - 1]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1
10
100, 101
1000, 1001, 1010
10000, 10001, 10010, 10100, 10101

1 0 1 1 2
0 1 1 2 3
 */