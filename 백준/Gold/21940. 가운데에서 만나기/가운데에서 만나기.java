import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dis = new int[N + 1][N + 1];
        int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dis[start][end] = Math.min(cost, dis[start][end]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dis[i][k] == INF || dis[k][j] == INF) {
                        continue;
                    }
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        int count = Integer.parseInt(br.readLine());
        int[] address = new int[count];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            address[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> centers = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int distances = 0;
            for (int start : address) {
                distances = Math.max(distances, dis[start][i] + dis[i][start]);
            }

            if (distances == min) {
                centers.add(i);
            } else if (distances < min) {
                min = distances;
                centers = new ArrayList<>();
                centers.add(i);
            }
        }

        Collections.sort(centers);
        StringBuilder sb = new StringBuilder();
        for (int start : centers) {
            sb.append(start).append(" ");
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
문제 조건 좀 깔끔하게 줬으면..
 */