import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] costs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        int[] maxCost = new int[N + 1];
        maxCost[1] = costs[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                maxCost[i] = Math.max(maxCost[i], maxCost[i - j] + maxCost[j]);
            }
            maxCost[i] = Math.max(costs[i], maxCost[i]);
        }
        System.out.println(maxCost[N]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1 -> 1
2 -> 2 or 11
3 -> 3 or dp[2]+1
4 -> 4 or dp[3]+1 or dp[2]+dp[2]
5 -> 5 or dp[4]+1 or dp[3]+dp[2]
6 -> 6 or dp[5]+1 or dp[4]+dp[2] or dp[3]+dp[3]
 */