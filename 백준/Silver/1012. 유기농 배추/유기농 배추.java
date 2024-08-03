import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            boolean[][] ground = new boolean[row][col];
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                int nowX = Integer.parseInt(st.nextToken());
                int nowY = Integer.parseInt(st.nextToken());
                ground[nowY][nowX] = true;
            }

            Queue<Point> queue = new LinkedList<>();
            int result = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (ground[j][k]) {
                        ground[j][k] = false;
                        queue.add(new Point(j, k));
                        while(!queue.isEmpty()) {
                            Point p = queue.remove();
                            for (int l = 0; l < 4; l++) {
                                int nowX = p.col + dx[l];
                                int nowY = p.row + dy[l];
                                if (nowX < 0 || nowX >= col || nowY < 0 || nowY >= row) {
                                    continue;
                                }
                                if (ground[nowY][nowX]) {
                                    ground[nowY][nowX]=false;
                                    queue.add(new Point(nowY, nowX));
                                }
                            }
                        }
                        result++;
                    }
                }
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