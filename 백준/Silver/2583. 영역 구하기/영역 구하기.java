import java.util.*;
import java.io.*;

class Solution {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] board; // 직사각형 1, 빈칸 0 , 방문 -1
    static StringTokenizer st;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Queue<Point> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        drawBoard(n);

        bw.write(bfs(row, col) + "\n");
        while(!pq.isEmpty()) {
            bw.write(pq.remove() + " ");
        }
        bw.flush();
        bw.close();
    }

    public void drawBoard(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 4 0 6 2 ->인덱스화 0,4 2,6
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    board[j][k] = 1;
                }
            }
        }
    }

    public int bfs(int row, int col) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = -1;
                    queue.add(new Point(i, j));
                    int size = 0;
                    while(!queue.isEmpty()) {
                        Point p = queue.remove();
                        size++;
                        for (int k = 0; k < 4; k++) {
                            int nowY = p.row + dy[k];
                            int nowX = p.col + dx[k];
                            if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                                continue;
                            }
                            if (board[nowY][nowX] == 0) {
                                board[nowY][nowX] = -1;
                                queue.add(new Point(nowY, nowX));
                            }
                        }
                    }
                    pq.add(size);
                    count++;
                }
            }
        }
        return count;
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
