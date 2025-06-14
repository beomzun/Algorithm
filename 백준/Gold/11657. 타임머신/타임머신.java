import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new int[]{B, C});
        }

        int INF = 60_000_001;
        long[] dis = new long[N+1];
        Arrays.fill(dis, INF);
        dis[1] = 0L;

        for(int i=1;i<N;i++) {
            for(int j=1;j<=N;j++) {
                //아직 1과 연결이 안됐다면 패스
                if (dis[j] == INF) {
                    continue;
                }

                for(int[] bus : graph[j]) {
                    int end = bus[0];
                    int cost = bus[1];
                    dis[end] = Math.min(dis[end], dis[j] + cost);
                }
            }
        }

        //사이클 검증
        for(int j=1;j<=N;j++) {
            for(int[] bus : graph[j]) {
                int end = bus[0];
                int cost = bus[1];

                //사이클 탐지 전에 방문여부 먼저 파악해야함.
                if (dis[end] == INF) {
                    continue;
                }

                //사이클 존재
                if (dis[end] > dis[j] + cost) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++) {
            if (dis[i] == INF) {
                dis[i] = -1;
            }
            sb.append(dis[i]).append("\n");
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
/*
N개의 도시 \ M개의 버스 시작,도착,소요시간
소요시간이 0이면 순간이동, 음수면 타임머신임ㅋㅋ
1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간 -> 음수 가중치 그래프 -> 벨만포드
무한한 과거로 가는 경우가 있다면 -1만 출력 \ 아니면 차례로 걸리는 시간 출력 \ 해당 도시로 가는 경우가 없으면 -1
---
1과 연결되지 않았다면 패스
 */