import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] base = new int[K];
        for (int i = 0; i < K; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        boolean[] visit = new boolean[N + 1];
        int visitCount = 0;
        Queue<int[]> cables = new PriorityQueue<>((c1, c2) -> c1[1] - c2[1]);
        for (int num : base) {
            visit[num] = true;
            visitCount++;
        }
        for (int num : base) {
            for (int[] next : graph[num]) {
                if (visit[next[0]]) {
                    continue;
                }
                cables.add(next);
            }
        }

        int totalCost = 0;
        while(!cables.isEmpty()) {
            int[] cable = cables.remove();
            int num = cable[0];
            int cost = cable[1];
            if (visit[num]) {
                continue;
            }
            visit[num] = true;
            visitCount++;
            totalCost += cost;
            if (visitCount == N) {
                break;
            }
            for (int[] next : graph[num]) {
                if (visit[next[0]]) {
                    continue;
                }
                cables.add(next);
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
