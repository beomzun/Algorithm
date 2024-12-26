import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] dis = new int[N + 1][N + 1];
        int INF = 10_000_000;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dis[start][end] = Math.min(dis[start][end], cost);
        }
        ArrayList<Integer>[][] path = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                path[i][j] = new ArrayList<>();
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dis[i][k] == INF || dis[k][j] == INF) {
                        continue;
                    }

                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];

                        path[i][j].clear();
                        path[i][j].addAll(path[i][k]);
                        path[i][j].add(k);
                        path[i][j].addAll(path[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(dis[i][j] == INF ? 0 : dis[i][j]).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || dis[i][j] == INF) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(2 + path[i][j].size()).append(" ");
                sb.append(i).append(" ");
                for (int k : path[i][j]) {
                    sb.append(k).append(" ");
                }
                sb.append(j).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
입력
- 도시개수 \ 버스 개수 \ 버스 정보
출력
- n개의 줄에 row,col  = row에서 col로 가는데 최소 비용
- i*n+j 번째 줄에는 i에서 j로 가는 최소 비용에 포함되어있는 도시의 개수 K 출력 + 그 줄에 이어서 i에서 j로 가는 경로 (i,j 포함) 출력
 */