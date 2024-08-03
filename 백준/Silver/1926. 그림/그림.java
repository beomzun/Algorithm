import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        boolean[][] draw = new boolean[row][column];
        boolean[][] visit = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                draw[i][j] = Integer.parseInt(st.nextToken()) == 1;
                visit[i][j] = false;
            }
        }

        int count = 0;
        int size = Integer.MIN_VALUE;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int tmp_size = 0;
                if (draw[i][j] && !visit[i][j]) {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    count++;
                }
                while(!queue.isEmpty()) {
                    Point p = queue.remove();
                    tmp_size++;
                    //상하좌우 1. 범위확인 후 2. 1이고 3. 방문 안했으면 큐에 추가
                    if (p.row >= 1 && draw[p.row-1][p.column] && !visit[p.row-1][p.column]) {
                        queue.add(new Point(p.row - 1, p.column));
                        visit[p.row - 1][p.column] = true;
                    }
                    if (p.column >= 1 && draw[p.row][p.column - 1] && !visit[p.row][p.column - 1]) {
                        queue.add(new Point(p.row, p.column - 1));
                        visit[p.row][p.column - 1] = true;
                    }
                    if (p.column + 1 < column && draw[p.row][p.column + 1] && !visit[p.row][p.column + 1]) {
                        queue.add(new Point(p.row, p.column + 1));
                        visit[p.row][p.column + 1] = true;
                    }
                    if (p.row + 1 < row && draw[p.row + 1][p.column] && !visit[p.row + 1][p.column]) {
                        queue.add(new Point(p.row + 1, p.column));
                        visit[p.row + 1][p.column] = true;
                    }
                }
                size = Math.max(tmp_size, size);
            }
        }
        bw.write(count + "\n" + size);
        bw.flush();
        bw.close();
    }
}
class Point {
    int row;
    int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}