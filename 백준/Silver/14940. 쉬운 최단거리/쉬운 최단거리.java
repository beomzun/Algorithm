import java.util.*;
import java.io.*;
class Solution {
    int N;
    int M;
    int y;
    int x;
    int[][] dis;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new int[N][M];
        y = 0;
        x = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                dis[i][j] = val;
                if (val == 1) {
                    dis[i][j] = Integer.MAX_VALUE;
                }
                if (val == 2) {
                    dis[i][j] = 0;
                    y = i;
                    x = j;
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(dis[i][j] == Integer.MAX_VALUE ? -1 : dis[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    public void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        q.add(new int[]{y, x});
        visit[y][x] = true;
        while(!q.isEmpty()) {
            int[] now = q.remove();
            for (int i = 0; i < 4; i++) {
                int nY = now[0] + dy[i];
                int nX = now[1] + dx[i];
                if (nY < 0 || nY >= N || nX < 0 || nX >= M || visit[nY][nX] || dis[nY][nX] == 0) {
                    continue;
                }
                visit[nY][nX] = true;
                dis[nY][nX] = dis[now[0]][now[1]] + 1;
                q.add(new int[]{nY, nX});
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
