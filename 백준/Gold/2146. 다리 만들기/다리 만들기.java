import java.util.*;
import java.io.*;

class Solution {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] island = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 번호
        int num = 2;
        //첫 Bfs용도
        Queue<Point> queue = new LinkedList<>();
        //다리 bfs용도
        Queue<Point> sea_queue = new LinkedList<>();
        //해당 위치의 바다에서 가장가까운 육지 위치
        Point[][] sea = new Point[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //방문하지 않은 섬의 경우
                if (island[i][j] == 1) {
                    island[i][j] = num;
                    queue.add(new Point(i,j));
                    while(!queue.isEmpty()) {
                        Point p = queue.remove();
                        for (int k = 0; k < 4; k++) {
                            int nowY = p.row + dy[k];
                            int nowX = p.col + dx[k];
                            if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= n) {
                                continue;
                            }
                            //땅인 경우 섬번호 할당
                            if (island[nowY][nowX] == 1) {
                                island[nowY][nowX] = num;
                                queue.add(new Point(nowY, nowX));
                            }
                            //방문한 바다인 경우 = 처음이니까 한칸 거리인 경우 && 섬 번호가 달라야함
                            if (island[nowY][nowX] == -1
                                    && island[sea[nowY][nowX].row][sea[nowY][nowX].col] != island[p.row][p.col]) {
                                System.out.println(1);
                                return;
                            }
                            //바다인 경우 방문했으므로 -1표시, 가까운 육지 표시
                            if (island[nowY][nowX] == 0) {
                                island[nowY][nowX] = -1;
                                sea_queue.add(new Point(nowY, nowX));
                                sea[nowY][nowX] = new Point(p.row, p.col);
                            }
                        }
                    }
                    num++;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        while(!sea_queue.isEmpty()) {
            Point p = sea_queue.remove();
            for (int i = 0; i < 4; i++) {
                int nowY = p.row + dy[i];
                int nowX = p.col + dx[i];
                if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= n) {
                    continue;
                }
                //방문안한 바다인 경우
                if (island[nowY][nowX] == 0) {
                    island[nowY][nowX] = -1;
                    sea_queue.add(new Point(nowY, nowX));
                    sea[nowY][nowX] = sea[p.row][p.col];
                }

                //각 섬의 가장 가까운 섬번호가 다른 경우
                if (island[nowY][nowX] == -1) {
                    int island_1 = island[sea[nowY][nowX].row][sea[nowY][nowX].col];
                    int island_2 = island[sea[p.row][p.col].row][sea[p.row][p.col].col];
                    if (island_1 != island_2) {
                        Point start = sea[p.row][p.col];
                        Point end = sea[nowY][nowX];
                        result = Math.min(result, Math.abs(start.row - end.row) + Math.abs(start.col - end.col) - 1);
                    }
                }
            }
        }
        System.out.println(result);
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