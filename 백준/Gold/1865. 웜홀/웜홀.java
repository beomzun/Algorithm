import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            Edge[] edges = new Edge[M * 2 + W];
            //도로는 양방향 시간은 흐른다.
            for (int i = 0, idx = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[idx++] = new Edge(S, E, T);
                edges[idx++] = new Edge(E, S, T);
            }
            //웜홀은 단방향 시간은 역순으로
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[M * 2 + i] = new Edge(S, E, -T);
            }

            int[] dis = new int[N + 1];
            int INF = 5_000_000;
            Arrays.fill(dis, INF);
            for (int i = 0; i < N; i++) {
                for(Edge e : edges) {
                    if (dis[e.e] > dis[e.s] + e.t) {
                        dis[e.e] = dis[e.s] + e.t;
                    }
                }
            }
            boolean flag = false;
            for(Edge e : edges) {
                if (dis[e.e] > dis[e.s] + e.t) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
class Edge {
    int s;
    int e;
    int t;
    Edge(int s, int e, int t) {
        this.s=s;
        this.e=e;
        this.t=t;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
벨만포드
---
벨만포드 과정에서 갱신 조건에 dis[x]!=INF 조건을 넣게될경우, 시작 노드에서만 도달가능한 노드에 대한 음수사이클을 탐지한다.
 */