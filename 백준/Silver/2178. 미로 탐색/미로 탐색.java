import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        boolean[][] road = new boolean[row][column];
        int[][] dist = new int[row][column];
        for (int i = 0; i < row; i++) {
            String s = br.readLine();
            for (int j = 0; j < column; j++) {
                road[i][j] = Character.getNumericValue(s.charAt(j)) == 1;
                dist[i][j] = -1;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        dist[0][0] = 1;
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (p.row >= 1 && road[p.row - 1][p.column] && dist[p.row - 1][p.column] == -1) {
                queue.add(new Point(p.row - 1, p.column));
                dist[p.row - 1][p.column] = dist[p.row][p.column] + 1;
            }
            if (p.column >= 1 && road[p.row][p.column - 1] && dist[p.row][p.column - 1] == -1) {
                queue.add(new Point(p.row, p.column - 1));
                dist[p.row][p.column - 1] = dist[p.row][p.column] + 1;
            }
            if (p.column + 1 < column && road[p.row][p.column + 1] && dist[p.row][p.column + 1] == -1) {
                queue.add(new Point(p.row, p.column + 1));
                dist[p.row][p.column + 1] = dist[p.row][p.column] + 1;
            }
            if (p.row + 1 < row && road[p.row + 1][p.column] && dist[p.row + 1][p.column] == -1) {
                queue.add(new Point(p.row + 1, p.column));
                dist[p.row + 1][p.column] = dist[p.row][p.column] + 1;
            }
        }

        bw.write(dist[row - 1][column - 1] + "");
        bw.flush();
        bw.close();
    }
}
class Point {
    int row;
    int column;

    Point(int row, int column) {
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