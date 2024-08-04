import java.util.*;
import java.io.*;

class Solution {
    int[][] apart;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static Queue<Point> queue = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        apart = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                apart[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        
        bw.write(bfs(n) + "\n");
        while(!pq.isEmpty()) {
            bw.write(pq.remove() + "\n");
        }
        bw.flush();
        bw.close();
    }

    public int bfs(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (apart[i][j] == 1) {
                    int size = 0;
                    queue.add(new Point(i, j));
                    apart[i][j] = -1;
                    while(!queue.isEmpty()) {
                        Point p = queue.remove();
                        size++;
                        for (int k = 0; k < 4; k++) {
                            int nowY = p.row + dy[k];
                            int nowX = p.col + dx[k];
                            if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= n) {
                                continue;
                            }
                            if (apart[nowY][nowX] == 1) {
                                queue.add(new Point(nowY, nowX));
                                apart[nowY][nowX] = -1;
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