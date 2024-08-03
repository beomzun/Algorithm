import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] box = new int[row][column];
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        int day = 1;
        while(!queue.isEmpty()) {
            Point p = queue.remove();
            for (int i = 0; i < 4; i++) {
                int tmp_r = p.row + dy[i];
                int tmp_c = p.col + dx[i];
                if (tmp_r < 0 || tmp_r >= row || tmp_c < 0 || tmp_c >= column) {
                    continue;
                }
                if (box[tmp_r][tmp_c] == 0) {
                    box[tmp_r][tmp_c] = box[p.row][p.col] + 1;
                    day = box[tmp_r][tmp_c];
                    queue.add(new Point(tmp_r, tmp_c));
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        bw.write(day - 1 + "");
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