import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        bw.write(bfs(n, board) + " ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }

        bw.write(bfs(n, board) + "");
        bw.flush();
        bw.close();
    }

    public int bfs(int n, char[][] board) {
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};

        boolean[][] visit = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    char c = board[i][j];
                    queue.add(new Point(i, j));
                    while(!queue.isEmpty()) {
                        Point p = queue.remove();
                        for (int k = 0; k < 4; k++) {
                            int nowY = p.row + dy[k];
                            int nowX = p.col + dx[k];
                            if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= n) {
                                continue;
                            }
                            if (!visit[nowY][nowX] && board[nowY][nowX] == c) {
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