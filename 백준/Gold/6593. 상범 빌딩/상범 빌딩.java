import java.util.*;
import java.io.*;

class Solution {

    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 0, 0, 1, 0, 0};
    static int[] dx = {0, -1, 1, 0, 0, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int high = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            if (high == 0 && row == 0 && col == 0) {
                break;
            }

            char[][][] building = new char[high][row][col];
            boolean[][][] visit = new boolean[high][row][col];
            Queue<Point> queue = new LinkedList<>();
            for (int i = 0; i < high; i++) {
                for (int j = 0; j < row; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < col; k++) {
                        char tmp = s.charAt(k);
                        building[i][j][k] = tmp;
                        if (tmp == 'S') {
                            queue.add(new Point(i, j, k));
                            visit[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }
            int time = bfs(queue, high, row, col, building, visit);
            String result = time == 0 ? "Trapped!" : "Escaped in " + time + " minute(s).";
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public int bfs(Queue<Point> queue, int high, int row, int col, char[][][] building, boolean[][][] visit) {
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.remove();
                for (int j = 0; j < 6; j++) {
                    int nowZ = p.high + dz[j];
                    int nowY = p.row + dy[j];
                    int nowX = p.col + dx[j];
                    if (nowZ < 0 || nowZ >= high || nowY < 0 || nowY >= row || nowX < 0
                            || nowX >= col) {
                        continue;
                    }
                    if (building[nowZ][nowY][nowX] == 'E') {
                        return time + 1;
                    }
                    if (!visit[nowZ][nowY][nowX] && building[nowZ][nowY][nowX] == '.') {
                        queue.add(new Point(nowZ, nowY, nowX));
                        visit[nowZ][nowY][nowX] = true;
                    }
                }
            }
            time++;
        }
        return 0;
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
