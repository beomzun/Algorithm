import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long totalCost = 0L;
        int include = 0;
        boolean[] visit = new boolean[N + 1];
        Queue<int[]> flows = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        flows.add(new int[]{0, 1});
        while(!flows.isEmpty()) {
            int[] flow = flows.remove();
            int cost = flow[0];
            int to = flow[1];
            if(visit[to]) {
                continue;
            }
            visit[to] = true;
            include++;
            totalCost += cost;
            if (include == N) {
                break;
            }

            for (int i = 1; i <= N; i++) {
                if(visit[i] || i==to) {
                    continue;
                }
                flows.add(new int[]{costs[to][i], i});
            }
        }

        System.out.println(totalCost);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
