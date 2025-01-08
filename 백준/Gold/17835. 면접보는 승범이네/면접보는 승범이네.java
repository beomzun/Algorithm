import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v].add(new int[]{u, c});
        }

        long[] dis = new long[N + 1];
        boolean[] visit = new boolean[N + 1];
        long INF = Long.MAX_VALUE;
        Arrays.fill(dis, INF);
        Queue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(e -> e[1]));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int destination = Integer.parseInt(st.nextToken());
            q.add(new long[]{destination, 0});
        }

        while(!q.isEmpty()) {
            long[] edge = q.remove();
            int num = (int) edge[0];
            long cost = edge[1];
            if (visit[num]) {
                continue;
            }
            visit[num] = true;
            dis[num] = cost;
            for (int[] next : graph[num]) {
                if (visit[next[0]]) {
                    continue;
                }
                if (dis[next[0]] > cost + next[1]) {
                    dis[next[0]] = cost + next[1];
                    q.add(new long[]{next[0], cost + next[1]});
                }
            }
        }

        long max = 0;
        int maxNum = 0;
        for (int i = 1; i <= N; i++) {
            if (max < dis[i]) {
                max = dis[i];
                maxNum = i;
            }
        }
        System.out.println(maxNum+"\n"+max);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
파티처럼 rGraph 사용.
 */