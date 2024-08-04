import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int high = Integer.parseInt(st.nextToken());

        int[][][] box = new int[high][row][col];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    box[i][j][k] = tmp;
                    if (tmp == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }

        int[] dh = {0, 0, 0, 0, -1, 1};
        int[] dy = {-1, 0, 0, 1, 0, 0};
        int[] dx = {0, -1, 1, 0, 0, 0};
        int day = 0;
        boolean isZero = false;
        while(!queue.isEmpty()) {
            Point p = queue.remove();
            for (int l = 0; l < 6; l++) {
                int nowH = p.high + dh[l];
                int nowY = p.row + dy[l];
                int nowX = p.col + dx[l];
                if (nowH < 0 || nowH >= high || nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                    continue;
                }
                if (box[nowH][nowY][nowX] == 0) {
                    isZero = true;
                    box[nowH][nowY][nowX] = box[p.high][p.row][p.col] + 1;
                    day = box[nowH][nowY][nowX];
                    queue.add(new Point(nowH, nowY, nowX));
                }
            }
        }

        for (int i = 0; i < high; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if (isZero) {
            bw.write(day - 1 + "");
        } else {
            bw.write(0 + "");
        }
        bw.flush();
        bw.close();
    }
}
class Point {
    int high;
    int row;
    int col;
    Point(int high, int row, int col) {
        this.high = high;
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