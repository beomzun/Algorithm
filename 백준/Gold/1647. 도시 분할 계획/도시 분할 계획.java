import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        Queue<int[]> edges = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        edges.add(new int[]{1, 0});

        boolean[] visit = new boolean[N + 1];
        int visitCount = 0;
        int totalCost = 0;
        int maxCost = 0;
        while (!edges.isEmpty()) {
            int[] edge = edges.remove();
            int to = edge[0];
            int cost = edge[1];
            if (visit[to]) {
                continue;
            }
            totalCost += cost;
            maxCost = Math.max(maxCost, cost);
            visit[to] = true;
            visitCount++;
            if (visitCount == N) {
                break;
            }
            for (int[] next : graph[to]) {
                int nTo = next[0];
                if (visit[nTo]) {
                    continue;
                }
                edges.add(next);
            }
        }

        System.out.println(totalCost - maxCost);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
