import java.util.*;
import java.io.*;

class Solution {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        if (row == 1 && col == 1) {
            System.out.println(1);
            return;
        }

        int[][] room = new int[row][col];
        for (int i = 0; i < row; i++) {
            String s = br.readLine();
            for (int j = 0; j < col; j++) {
                room[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        Point start = new Point(false, 0, 0);
        Point end = new Point(false, row - 1, col - 1);
        int toEnd = bfs(row, col, room, start, end);
        int toStart = bfs(row, col, room, end, start);
        int result = 0;
        if (toEnd == -1 && toStart == -1) {
            result = -1;
        } else if (toEnd != -1 && toStart != -1) {
            result = Math.min(toEnd, toStart);
        } else {
            result = toEnd == -1 ? toStart : toEnd;
        }
        System.out.println(result);
    }

    public int bfs(int row, int col, int[][] room, Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[row][col];
        queue.add(new Point(false, start.row, start.col));
        visit[start.row][start.col] = true;

        int time = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Point p = queue.remove();
                if (p.row == end.row && p.col == end.col) {
                    return time;
                }
                for (int l = 0; l < 4; l++) {
                    int nowY = p.row + dy[l];
                    int nowX = p.col + dx[l];
                    if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                        continue;
                    }
                    if (!visit[nowY][nowX]) {
                        if (room[nowY][nowX] == 0) {
                            queue.add(new Point(p.broke, nowY, nowX));
                            visit[nowY][nowX] = true;
                        }
                        if (room[nowY][nowX] == 1 && !p.broke) {
                            queue.add(new Point(true, nowY, nowX));
                            visit[nowY][nowX] = true;
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
class Point {
    boolean broke;
    int row;
    int col;
    Point(boolean broke, int row, int col) {
        this.broke = broke;
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
