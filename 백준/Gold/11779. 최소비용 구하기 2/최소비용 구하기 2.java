import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dis = new int[N + 1];
        int[] parents = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dis, INF);

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        q.add(new int[]{0, start, 0});
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int num = now[1];
            int cost = now[2];
            if (visit[num]) {
                continue;
            }
            visit[num] = true;
            dis[num] = cost;
            for (int[] edge : graph[num]) {
                if (visit[edge[0]]) {
                    continue;
                }
                if (dis[edge[0]] >= cost + edge[1]) {
                    parents[edge[0]] = num;
                    dis[edge[0]] = cost + edge[1];
                    q.add(new int[]{num, edge[0], cost + edge[1]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dis[end]).append("\n");

        Stack<Integer> stack = new Stack<>();
        int next = end;
        while (next != start) {
            stack.add(next);
            next = parents[next];
        }
        stack.add(start);

        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
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
