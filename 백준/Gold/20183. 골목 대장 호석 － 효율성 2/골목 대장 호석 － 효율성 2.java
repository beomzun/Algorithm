import java.util.*;
import java.io.*;
class Solution {
    int N;
    int start;
    int end;
    long C;
    ArrayList<int[]>[] graph;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        int left = 1;
        int billion = 1_000_000_000;
        int right = billion;
        while (left < right) {
            int mid = (left + right) / 2;
            if (dijkstra(mid)) {
                right = mid;
                continue;
            }
            
            left = mid + 1;
        }

        System.out.println(right == billion ? -1 : right);
    }
    public boolean dijkstra(int max) {
        boolean[] visit = new boolean[N+1];
        long[] dis = new long[N+1];
        long INF = Long.MAX_VALUE;
        Arrays.fill(dis, INF);
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingLong(e->e.dis));
        edges.add(new Edge(start, 0));
        while(!edges.isEmpty()) {
            Edge e = edges.remove();
            int num = e.to;
            long d = e.dis;
            if(visit[num]) {
                continue;
            }
            visit[num]=true;
            dis[num] = d;
            for(int[] edge : graph[num]) {
                if (visit[edge[0]] || edge[1] > max) {
                    continue;
                }
                if (dis[edge[0]] > d + edge[1]) {
                    dis[edge[0]] = d+edge[1];
                    edges.add(new Edge(edge[0], dis[edge[0]]));
                }
            }
        }

        return dis[end] <= C;
    }
}
class Edge {
    int to;
    long dis;
    Edge(int to, long dis) {
        this.to=to;
        this.dis=dis;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
전체 비용 / 최대 수치심 | 비용업,수치심다운 : 우선순위 기준 - 수치심
-> 다익스트라와 맞지않음. 중간에 바뀔수있기때문
---
매개변수 탐색
 */