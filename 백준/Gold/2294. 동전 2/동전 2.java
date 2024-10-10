import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];

        Arrays.fill(coins, Integer.MAX_VALUE);
        coins[0] = Integer.parseInt(br.readLine());
        int count = 1;  //중복없는 코인 수
        for (int i = 1; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now == coins[count - 1]) {
                continue;
            }
            coins[count++] = now;
        }
        Arrays.sort(coins);

        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < count; i++) {
            for (int j = coins[i]; j <= K; j++) {
                if (dp[j - coins[i]] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        int result = dp[K] == Integer.MAX_VALUE ? -1 : dp[K];
        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
15 - 1 5 12
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1   1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
5   1 2 3 4 1 2 3 4 5 2  3  4  5  6  3
12  1 2 3 4 1 2 3 4 5 2  3  1  2  3  3

7 - 3 5
    1 2 3 4 5 6 7
3   x x 1 x x 2 x
5   x x 1 x 1 2 x
 */