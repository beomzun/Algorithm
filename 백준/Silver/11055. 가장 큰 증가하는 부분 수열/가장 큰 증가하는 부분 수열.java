import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers[0] = Integer.parseInt(st.nextToken());
        dp[0] = numbers[0];
        if (N == 1) {
            System.out.println(numbers[0]);
            return;
        }

        int result = dp[0];
        for (int i = 1; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = numbers[i];
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[j] + numbers[i], dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
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
현재 수 이전의 수들 중 현재수보다 작은게 있다면, 해당위치에서의 부분합에 현재값추가하여 값 갱신
 */