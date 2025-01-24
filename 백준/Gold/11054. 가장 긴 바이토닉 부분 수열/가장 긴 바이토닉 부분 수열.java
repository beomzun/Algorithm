import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][N];
        dp[0][0] = dp[1][N - 1] = 1;
        List<Integer> incL = new ArrayList<>();
        incL.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int val = arr[i];
            if (val > incL.get(incL.size() - 1)) {
                incL.add(val);
                dp[0][i] = dp[0][i - 1] + 1;
                continue;
            }
            dp[0][i] = dp[0][i - 1];
            int left = 0;
            int right = incL.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (val == incL.get(mid)) {
                    left = mid;
                    break;
                } else if (val > incL.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            incL.set(left, val);
        }

        List<Integer> decL = new ArrayList<>();
        decL.add(arr[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            int val = arr[i];
            if (val > decL.get(decL.size() - 1)) {
                decL.add(val);
                dp[1][i] = dp[1][i + 1] + 1;
                continue;
            }
            dp[1][i] = dp[1][i + 1];
            int left = 0;
            int right = decL.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (val == decL.get(mid)) {
                    left = mid;
                    break;
                } else if (val > decL.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            decL.set(left, val);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[0][i] + dp[1][i] - 1);
        }
        System.out.println(max);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
왼쪽에서 오르쪽 방향으로 증가수열 incL
오른쪽에서 왼쪽 방향으로 증가수열 decL
---
처음에는 오왼증가수열을 왼오 감소수열로 구현했으나 인덱스 매칭이 되질 않았음 => 결국 끝 인덱스가 가장 큰 값.
내가 의도한 것은 해당 위치까지의 증가수열과 해당 위치부터의 감소수열 합이 가장 큰 것이었기 때문
 */