import java.util.*;
import java.io.*;
class Solution {
    Map<Integer, Integer>[] graph;
    int max = 0;
    int maxNode = 1;
    boolean[] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new HashMap[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new HashMap<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[parent].put(child,weight);
            graph[child].put(parent, weight);
        }
        visit = new boolean[N + 1];
        dfs(1, 0);
        visit = new boolean[N + 1];
        dfs(maxNode, 0);

        System.out.println(max);
    }

    public void dfs(int start, int dis) {
        if (dis > max) {
            max = dis;
            maxNode = start;
        }

        visit[start] = true;
        for (int child : graph[start].keySet()) {
            if (visit[child]) {
                continue;
            }
            dfs(child, dis + graph[start].get(child));
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
bfs + dp
부모가 알고있는 노드와의 거리 참조
---
메모리초과..
dfs N번 하고 그 중에서 가장 긴 쌍
---
루트에서 dfs해서 가장 먼 노드. 에서 dfs해서 가장 먼 노드.
 */