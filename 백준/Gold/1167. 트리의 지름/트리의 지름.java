import java.util.*;
import java.io.*;
class Solution {
    Map<Integer, Integer>[] graph;
    boolean[] visit;
    int max = 0;
    int maxStart = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        graph = new Map[V + 1];
        for (int v = 1; v <= V; v++) {
            graph[v] = new HashMap<>();
        }
        for (int v = 0; v < V; v++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while (next != -1) {
                int dis = Integer.parseInt(st.nextToken());
                graph[parent].put(next, dis);

                next = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[V + 1];
        dfs(1, 0);
        Arrays.fill(visit, false);
        dfs(maxStart, 0);

        System.out.println(max);
    }

    public void dfs(int now, int sum) {
        if (sum > max) {
            max = sum;
            maxStart = now;
        }

        visit[now] = true;
        for (int next : graph[now].keySet()) {
            if (visit[next]) {
                continue;
            }
            dfs(next, sum + graph[now].get(next));
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
