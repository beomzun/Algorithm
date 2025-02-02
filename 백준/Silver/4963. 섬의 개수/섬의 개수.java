import java.util.*;
import java.io.*;
class Solution {
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    int w;
    int h;
    int[][] map;
    boolean[][] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0) {
                break;
            }

            map = new int[h][w];
            visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public void bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visit[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int curY = current[0];
            int curX = current[1];

            for (int i = 0; i < 8; i++) {
                int nY = curY + dy[i];
                int nX = curX + dx[i];

                if (nY < 0 || nY >= h || nX < 0 || nX >= w || visit[nY][nX] || map[nY][nX] == 0) {
                    continue;
                }
                visit[nY][nX] = true;
                queue.add(new int[]{nY, nX});
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
