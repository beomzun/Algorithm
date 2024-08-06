import java.util.*;
import java.io.*;

class Solution {

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static Queue<Point> queue = new LinkedList<>();
    static int[][] ice;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        ice = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp != 0) {
                    ice[i][j] = tmp;
                    queue.add(new Point(i, j));
                }
            }
        }

        int time = 0;
        while (true) {
            melt(row, col);
            time++;

            int result = bfs(row, col);

            if (result == 0) {
                System.out.println(0);
                return;
            }
            if (result == 2) {
                System.out.println(time);
                return;
            }
        }
    }

    public void melt(int row, int col) {
        boolean[][] visit = new boolean[row][col];
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            visit[p.row][p.col] = true;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nowY = p.row + dy[i];
                int nowX = p.col + dx[i];
                if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                    continue;
                }
                if (ice[nowY][nowX] == 0 && !visit[nowY][nowX]) {
                    count++;
                }
            }
            ice[p.row][p.col] = Math.max(ice[p.row][p.col] - count, 0);
        }
    }

    public int bfs(int row, int col) {
        Queue<Point> bfs_queue = new LinkedList<>();
        boolean[][] visit = new boolean[row][col];
        boolean over = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ice[i][j] > 0 && !visit[i][j]) {
                    //나뉘었을 때
                    if (over) {
                        return 2;
                    }
                    over = true;

                    bfs_queue.add(new Point(i, j));
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    while (!bfs_queue.isEmpty()) {
                        Point p = bfs_queue.remove();
                        for (int k = 0; k < 4; k++) {
                            int nowY = p.row + dy[k];
                            int nowX = p.col + dx[k];
                            if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                                continue;
                            }
                            if (ice[nowY][nowX] > 0 && !visit[nowY][nowX]) {
                                bfs_queue.add(new Point(nowY, nowX));
                                queue.add(new Point(nowY, nowX));
                                visit[nowY][nowX] = true;
                            }
                        }
                    }
                }
            }
        }
        //모두 녹았을 때
        if (!over) {
            return 0;
        }
        //아직 하나일 때
        return 1;
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
