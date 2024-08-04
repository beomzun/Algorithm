import java.util.*;
import java.io.*;
class Solution {
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

            Queue<Point> queue = new LinkedList<>();
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

            int[] dy = {-1, 0, 0, 1};
            int[] dx = {0, -1, 1, 0};
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

            queue.add(new Point(sg.row, sg.col));
            String result = "IMPOSSIBLE";
            int time = 0;
            boolean out = false;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Point p = queue.remove();
                    for (int k = 0; k < 4; k++) {
                        int nowY = p.row + dy[k];
                        int nowX = p.col + dx[k];

                        if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                            out = true;
                            result = String.valueOf(time + 1);
                            break;
                        }
                        if (building[nowY][nowX] == '.' && (time + 1 < fire[nowY][nowX] || fire[nowY][nowX] == 0)) {
                            building[nowY][nowX] = '*';
                            queue.add(new Point(nowY, nowX));
                        }
                    }
                }
                if (out) {
                    break;
                }
                time++;
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
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