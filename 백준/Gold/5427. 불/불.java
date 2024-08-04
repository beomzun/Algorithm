import java.util.*;
import java.io.*;
class Solution {
    static Queue<Point> queue = new LinkedList<>();
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            char[][] building = new char[row][col];
            int[][] fire = new int[row][col];

            Point sg = null;
            for (int j = 0; j < row; j++) {
                String s = br.readLine();
                for (int k = 0; k < col; k++) {
                    building[j][k] = s.charAt(k);
                    if (s.charAt(k) == '@') {
                        sg = new Point(j, k);
                    }
                    if (s.charAt(k) == '*') {
                        queue.add(new Point(j, k));
                        fire[j][k] = 0;
                    }
                }
            }

            fireBfs(row, col, building, fire);
            queue.add(new Point(sg.row, sg.col));
            bw.write(sgBfs(row, col, building, fire) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public void fireBfs(int row, int col, char[][] building, int[][] fire) {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Point p = queue.remove();
                for (int k = 0; k < 4; k++) {
                    int nowY = p.row + dy[k];
                    int nowX = p.col + dx[k];

                    if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                        continue;
                    }
                    if ((building[nowY][nowX] == '.' || building[nowY][nowX] == '@') && fire[nowY][nowX] == 0) {
                        queue.add(new Point(nowY, nowX));
                        fire[nowY][nowX] = fire[p.row][p.col] + 1;
                    }
                }
            }
        }
    }

    public String sgBfs(int row, int col, char[][] building, int[][] fire) {
        String result = "IMPOSSIBLE";
        int time = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Point p = queue.remove();
                for (int k = 0; k < 4; k++) {
                    int nowY = p.row + dy[k];
                    int nowX = p.col + dx[k];

                    if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                        return String.valueOf(time);
                    }
                    if (building[nowY][nowX] == '.' && (time < fire[nowY][nowX] || fire[nowY][nowX] == 0)) {
                        building[nowY][nowX] = '*';
                        queue.add(new Point(nowY, nowX));
                    }
                }
            }
            time++;
        }
        return result;
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
