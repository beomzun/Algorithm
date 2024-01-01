import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }
        boolean[][] visit = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(arr, visit, i, j, n);
                    count++;
                }
            }
        }
        bw.write(count + " ");
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].equals("G")) {
                    arr[i][j] = "R";
                }
                visit[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(arr, visit, i, j, n);
                    count++;
                }
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static void bfs(String[][] arr, boolean[][] visit, int y, int x, int n) {
        Queue<int[]> queue = new LinkedList<>();
        String color = arr[y][x];
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.remove();
            int nowY = tmp[0];
            int nowX = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nextY = nowY + dy[k];
                int nextX = nowX + dx[k];
                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                    continue;
                }
                if (arr[nextY][nextX].equals(color) && !visit[nextY][nextX]) {
                    visit[nextY][nextX] = visit[nowY][nowX];
                    queue.add(new int[]{nextY, nextX});
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