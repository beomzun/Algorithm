import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            dp[val] = dp[val - 1] + 1;
            max = Math.max(max, dp[val]);
        }
        System.out.println(N - max);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
4 2 8 3 1 7 5 6 9
3 4 2 8 1 7 5 6 9
2 3 4 8 1 7 5 6 9
1 2 3 4 8 7 5 6 9
1 2 3 4 8 5 6 9 7
1 2 3 4 5 6 9 7 8
1 2 3 4 5 6 7 8 9
---
4 2 8 3 1 7 5 6 9
1 4 2 8 3 7 5 6 9
3 1 4 2 8 7 5 6 9
3 1 4 2 8 5 6 9 7
3 1 4 2 5 6 9 7 8
3 1 4 2 5 6 7 8 9
2 3 1 4 5 6 7 8 9
1 2 3 4 5 6 7 8 9
---
가장 긴 연속된 놈들만 fix. 다른 가운데 낀 녀석들은 어차피 옮기면 흩어짐 + 파급력이 있음
 */