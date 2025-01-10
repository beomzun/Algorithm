import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, i});
            graph[b].add(new int[]{a, i});
        }

        long[] dis = new long[N + 1];
        boolean[] visit = new boolean[N + 1];
        long INF = Long.MAX_VALUE;
        Arrays.fill(dis, INF);
        visit[1] = true;
        dis[1] = 0;
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingLong(e->e.cost));
        for (int[] init : graph[1]) {
            if (dis[init[0]] > init[1] + 1) {
                dis[init[0]] = init[1] + 1;
                edges.add(new Edge(init[0], dis[init[0]], init[1]));
            }
        }
        while (!edges.isEmpty()) {
            Edge edge = edges.remove();
            int num = edge.num;
            long cost = edge.cost;
            int count = edge.count;
            if(visit[num]) {
                continue;
            }
            visit[num] = true;
            dis[num] = cost;
            for (int[] next : graph[num]) {
                if (visit[next[0]]) {
                    continue;
                }
                int timeDif = count <= next[1] ? next[1] - count - 1 : (M - 1) - count + next[1];
                if (dis[next[0]] > cost + timeDif + 1) {
                    dis[next[0]] = cost + timeDif + 1;
                    edges.add(new Edge(next[0], dis[next[0]], next[1]));
                }
            }
        }
        System.out.println(dis[N]);
    }
}
class Edge {
    int num;
    long cost;
    int count;
    Edge(int num, long cost, int count) {
        this.num = num;
        this.cost = cost;
        this.count = count;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
주기 M분. M=5라면,
각 주기의 1 + i(0~M-1) => 1,2,3,4,5 번째 신호는 1번신호 예시(1,6,11,16) 분에 시작해서 1분 동안 파란불이 들어오고, 다른데는 빨간불.
이동하는데 1분걸림.
---
돌지말고 활성화 느낌으로 -> 다익스트라
 */