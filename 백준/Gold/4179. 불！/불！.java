import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        char[][] miro = new char[row][col];
        int[][] fire = new int[row][col];
        int[][] jh = new int[row][col];
        Queue<Point> queue_j = new LinkedList<>();
        Queue<Point> queue_f = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            String s = br.readLine();
            for (int j = 0; j < col; j++) {
                char type = s.charAt(j);
                miro[i][j] = type;
                if (type == 'J') {
                    queue_j.add(new Point(i, j));
                    jh[i][j] = 0;
                }
                if (type == 'F') {
                    queue_f.add(new Point(i, j));
                    fire[i][j] = 0;
                }
            }
        }

        while (!queue_f.isEmpty()) {
            Point p = queue_f.remove();
            for (int i = 0; i < 4; i++) {
                int nowX = p.col + dx[i];
                int nowY = p.row + dy[i];

                if (nowX < 0 || nowX >= col || nowY < 0 || nowY >= row) {
                    continue;
                }
                if ((miro[nowY][nowX] == '.' || miro[nowY][nowX] == 'J') && fire[nowY][nowX] == 0) {
                    fire[nowY][nowX] = fire[p.row][p.col] + 1;
                    queue_f.add(new Point(nowY, nowX));
                }
            }
        }

        boolean out = false;
        String result = "IMPOSSIBLE";
        while(!queue_j.isEmpty()) {
            Point p = queue_j.remove();
            for (int i = 0; i < 4; i++) {
                int nowX = p.col + dx[i];
                int nowY = p.row + dy[i];

                if (nowX < 0 || nowX >= col || nowY < 0 || nowY >= row) {
                    out = true;
                    result = String.valueOf(jh[p.row][p.col] + 1);
                    break;
                }
                if (miro[nowY][nowX] == '.' && (jh[p.row][p.col] < fire[nowY][nowX] - 1 || fire[nowY][nowX] == 0) && jh[nowY][nowX] == 0) {
                    jh[nowY][nowX] = jh[p.row][p.col] + 1;
                    queue_j.add(new Point(nowY, nowX));
                }
            }
            if(out) {
                break;
            }
        }

        bw.write(result);
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
