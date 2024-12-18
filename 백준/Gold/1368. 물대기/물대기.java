import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> edges = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(br.readLine());
            edges.add(new int[]{cost, i});
        }
        int[][] costs = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean[] visit = new boolean[N + 1];
        int totalCost = 0;
        int visitCount = 0;
        while(!edges.isEmpty()) {
            int[] edge = edges.remove();
            int cost = edge[0];
            int to = edge[1];
            if (visit[to]) {
                continue;
            }
            totalCost += cost;
            visit[to] = true;
            visitCount++;
            if (visitCount == N) {
                break;
            }
            for (int i = 1; i <= N; i++) {
                if (visit[i] || i == to) {
                    continue;
                }
                edges.add(new int[]{costs[to][i], i});
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