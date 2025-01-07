import java.util.*;
import java.io.*;
class Solution {
    int N;
    ArrayList<int[]>[] graph;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] disFromOne = new int[N+1];
        int[] disFromA = new int[N+1];
        int[] disFromB = new int[N+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(disFromOne,INF);
        Arrays.fill(disFromA,INF);
        Arrays.fill(disFromB,INF);

        dijkstra(1,disFromOne);
        dijkstra(v1,disFromA);
        dijkstra(v2,disFromB);

        int v1v2;
        if (disFromOne[v1] == INF || disFromA[v2] == INF || disFromB[N] == INF) {
            v1v2 = -1;
        } else {
            v1v2 = disFromOne[v1] + disFromA[v2] + disFromB[N];
        }

        int v2v1;
        if (disFromOne[v2] == INF || disFromB[v1] == INF || disFromA[N] == INF) {
            v2v1 = -1;
        } else {
            v2v1 = disFromOne[v2]+disFromB[v1]+disFromA[N];
        }

        if (v1v2 == -1 && v2v1 == -1) {
            System.out.println(-1);
        } else if (v1v2 == -1 || v2v1 == -1) {
            System.out.println(Math.max(v1v2, v2v1));
        } else {
            System.out.println(Math.min(v1v2, v2v1));
        }

    }
    public void dijkstra(int start, int[] dis) {
        Queue<int[]> edges = new PriorityQueue<>((e1,e2)->e1[1]-e2[1]);
        edges.add(new int[]{start,0});
        boolean[] visit = new boolean[N+1];
        while(!edges.isEmpty()) {
            int[] now = edges.remove();
            int num = now[0];
            int cost = now[1];
            if(visit[num]) {
                continue;
            }
            visit[num]=true;
            dis[num]=cost;
            for(int[] edge : graph[num]) {
                if(visit[edge[0]]) {
                    continue;
                }
                if(dis[edge[0]] > cost + edge[1]) {
                    dis[edge[0]] = cost+edge[1];
                    edges.add(new int[]{edge[0], dis[edge[0]]});
                }
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}