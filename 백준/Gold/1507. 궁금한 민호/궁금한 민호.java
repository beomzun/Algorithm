import java.util.*;
import java.io.*;
class Solution {
    int N;
    int INF = Integer.MAX_VALUE;
    int[][] result;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int[][] dis = new int[N + 1][N + 1];
        PriorityQueue<Edge> edges = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dis[i][j] = Integer.parseInt(st.nextToken());
                if (i < j) {
                    edges.add(new Edge(i, j, dis[i][j]));
                }
            }
        }

        result = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(result[i], INF);
            result[i][i] = 0;
        }

        if (edges.size() == 1) {
            System.out.println(edges.remove().cost);
            return;
        }
        int minCost = 0;
        Edge e = edges.remove();
        result[e.start][e.end] = e.cost;
        result[e.end][e.start] = e.cost;
        minCost += e.cost;
        e = edges.remove();
        result[e.start][e.end] = e.cost;
        result[e.end][e.start] = e.cost;
        minCost += e.cost;
        floyd();

        while(!edges.isEmpty()) {
            e = edges.remove();
            if (result[e.start][e.end] <= e.cost) {
                continue;
            }
            minCost += e.cost;
            result[e.start][e.end] = e.cost;
            result[e.end][e.start] = e.cost;
            floyd();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dis[i][j] != result[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(minCost);
    }
    public void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (result[i][k] == INF || result[k][j] == INF) {
                        continue;
                    }
                    result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                }
            }
        }
    }
}
class Edge {
    int start;
    int end;
    int cost;

    Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
