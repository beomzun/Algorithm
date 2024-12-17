import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});
        }

        boolean[] visit = new boolean[V + 1];
        Queue<int[]> edges = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        edges.add(new int[]{1, 0});
        int total = 0;
        while(!edges.isEmpty()) {
            int[] node = edges.remove();
            int now = node[0];
            int weight = node[1];
            if (visit[now]) {
                continue;
            }
            visit[now] = true;
            total += weight;
            for (int[] next : graph[now]) {
                if (visit[next[0]]) {
                    continue;
                }
                edges.add(next);
            }
        }

        System.out.println(total);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
프림으로 구현
 */