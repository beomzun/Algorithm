import java.util.*;
import java.io.*;
class Solution {
    int N;
    int X;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        ArrayList<int[]>[] rGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            rGraph[v].add(new int[]{u, w});
        }

        int[] disToX = new int[N + 1];
        int[] disFromX = new int[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(disToX, INF);
        Arrays.fill(disFromX, INF);
        dijkstra(disFromX, graph);
        dijkstra(disToX, rGraph);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, disToX[i] + disFromX[i]);
        }
        System.out.println(max);
    }

    private void dijkstra(int[] dis, ArrayList<int[]>[] graph) {
        boolean[] visit = new boolean[N + 1];
        Queue<int[]> edges = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        edges.add(new int[]{X, 0});
        while(!edges.isEmpty()) {
            int[] e = edges.remove();
            int num = e[0];
            int cost = e[1];
            if (visit[num]) {
                continue;
            }
            visit[num] = true;
            dis[num] = cost;
            for (int[] edge : graph[num]) {
                if (visit[edge[0]]) {
                    continue;
                }
                if (dis[edge[0]] > edge[1] + cost) {
                    dis[edge[0]] = edge[1] + cost;
                    edges.add(new int[]{edge[0], cost + edge[1]});
                }
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
