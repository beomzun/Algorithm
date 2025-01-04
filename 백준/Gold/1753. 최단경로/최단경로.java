import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int INF = Integer.MAX_VALUE;
        int[] dis = new int[V + 1];
        Arrays.fill(dis, INF);

        ArrayList<int[]>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        boolean[] visit = new boolean[V + 1];
        Queue<int[]> q = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        q.add(new int[]{start, 0});
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int num = now[0];
            int cost = now[1];
            if (visit[num]) {
                continue;
            }
            visit[num] = true;
            dis[num] = cost;
            for (int[] edge : graph[num]) {
                if (dis[edge[0]] >= dis[num] + edge[1]) {
                    dis[edge[0]] = dis[num] + edge[1];
                    q.add(new int[]{edge[0], dis[edge[0]]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dis[i] == INF) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dis[i]).append("\n");
        }
        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
