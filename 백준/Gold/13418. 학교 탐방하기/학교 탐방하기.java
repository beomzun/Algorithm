import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        //최대비용
        Queue<int[]> edges = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        edges.add(graph[0].get(0));
        int linkCount = 0;
        int upCount = 0;
        boolean[] visit = new boolean[N + 1];
        visit[0] = true;
        while(!edges.isEmpty()) {
            int[] now = edges.remove();
            int to = now[0];
            int cost = now[1];
            if (visit[to]) {
                continue;
            }
            visit[to] = true;
            linkCount++;
            if (cost == 0) {
                upCount++;
            }
            if (linkCount == N) {
                break;
            }
            for (int[] next : graph[to]) {
                if (visit[next[0]]) {
                    continue;
                }
                edges.add(next);
            }
        }
        int max = (int) Math.pow(upCount, 2);

        //최소비용
        edges = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        edges.add(graph[0].get(0));
        linkCount = 0;
        upCount = 0;
        Arrays.fill(visit, false);
        visit[0] = true;
        while(!edges.isEmpty()) {
            int[] now = edges.remove();
            int to = now[0];
            int cost = now[1];
            if (visit[to]) {
                continue;
            }
            visit[to] = true;
            linkCount++;
            if (cost == 0) {
                upCount++;
            }
            if (linkCount == N) {
                break;
            }
            for (int[] next : graph[to]) {
                if (visit[next[0]]) {
                    continue;
                }
                edges.add(next);
            }
        }

        int min = (int) Math.pow(upCount, 2);

        System.out.println(max - min);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
