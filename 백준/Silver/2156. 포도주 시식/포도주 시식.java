import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] grape = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = grape[1];
        if (N >= 2) {
            dp[2] = grape[1] + grape[2];
        }
        for (int i = 3; i <= N; i++) {
            // 12먹거나 13먹거나 23먹거나 -> 현재를 포함한 최신 3개 중에 하나를 제외한 것들중 비교하기
            dp[i] = Math.max(dp[i - 1],
                    Math.max(
                            dp[i - 2] + grape[i],
                            dp[i - 3] + grape[i - 1] + grape[i]
                    ));
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
3연음주 불가
OOX / OXO / XOO
 */