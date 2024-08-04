import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            bw.write(bfs(size, startY, startX, targetY, targetX) + "\n");
        }
        bw.flush();
        bw.close();
    }
    public int bfs(int size, int startY, int startX, int targetY, int targetX) {
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        boolean[][] visit = new boolean[size][size];
        int time = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startY, startX));
        visit[startY][startX] = true;
        while (!queue.isEmpty()) {
            int q_size = queue.size();
            for (int j = 0; j < q_size; j++) {
                Point p = queue.remove();
                if (p.row == targetY && p.col == targetX) {
                    return time;
                }
                for (int k = 0; k < 8; k++) {
                    int nowY = p.row + dy[k];
                    int nowX = p.col + dx[k];
                    if (nowY < 0 || nowY >= size || nowX < 0 || nowX >= size) {
                        continue;
                    }
                    if (!visit[nowY][nowX]) {
                        queue.add(new Point(nowY, nowX));
                        visit[nowY][nowX] = true;
                    }
                }
            }
            time++;
        }
        return -1;
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