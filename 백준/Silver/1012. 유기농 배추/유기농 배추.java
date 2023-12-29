import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    private void bfs(boolean[][] arr, int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = false; // 방문 체크

        // 상하좌우 탐색을 위한 방향 벡터
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int[] dir : directions) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                // 경계 체크 및 방문하지 않은 노드인지 확인
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && arr[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    arr[nextX][nextY] = false; // 방문 체크
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            boolean[][] arr = new boolean[n][m];

            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = true;
            }

            int dummy = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[j][k]) {
                        bfs(arr, j, k, n, m);
                        dummy++;
                    }
                }
            }
            bw.write(dummy + "\n");
        }
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
