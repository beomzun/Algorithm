import java.util.*;
import java.io.*;

class Solution {
    static long MOD = 1_000_000_003;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        if (K > N / 2) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i = 3; i <= N; i++) {
            for (int j = 2; j <= K && j <= i / 2 + 1; j++) {
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.println((dp[N - 3][K - 1] + dp[N - 1][K]) % MOD);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
수학적 규칙
---
그런거없음. 우선 선형으로 생각하고 dp 계산 후 결과만 원형으로 생각하여 응답..
 */