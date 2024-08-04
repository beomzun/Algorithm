import java.util.*;
import java.io.*;
class Solution {
    static int[][] top;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        top = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                top[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 1;
        int rain = 1;
        int count = 1;
        while (count != 0) {
            count = bfs(n, rain);
            max = Math.max(max, count);
            rain++;
        }
        
        System.out.println(max);
    }

    public int bfs(int n, int rain) {
        int count = 0;
        boolean[][] visit = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && top[i][j] > rain) {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point p = queue.remove();
                        for (int k = 0; k < 4; k++) {
                            int nowY = p.row + dy[k];
                            int nowX = p.col + dx[k];
                            if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= n) {
                                continue;
                            }
                            if (!visit[nowY][nowX] && top[nowY][nowX] > rain) {
                                queue.add(new Point(nowY, nowX));
                                visit[nowY][nowX] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
class Point {
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
