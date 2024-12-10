import java.util.*;
import java.io.*;
class Solution {
    ArrayList<Edge>[] graph;
    int max = 0;
    int maxStart = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        for (int v = 1; v <= V; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int v = 0; v < V; v++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while (next != -1) {
                int dis = Integer.parseInt(st.nextToken());
                graph[parent].add(new Edge(next, dis));
                next = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0, -1);
        dfs(maxStart, 0, -1);

        System.out.println(max);
    }

    public void dfs(int now, int sum, int parent) {
        if (sum > max) {
            max = sum;
            maxStart = now;
        }

        for (Edge edge : graph[now]) {
            if (edge.to != parent) {
                dfs(edge.to, sum + edge.weight, now);
            }
        }
    }
}
class Edge {
    int to, weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}