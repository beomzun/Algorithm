import java.util.*;
import java.io.*;
class Solution {

    static int[] k_dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] k_dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int skill = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] road = new int[row][col];
        boolean[][][] visit = new boolean[skill+1][row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Point> queue = new LinkedList<>();
        visit[0][0][0] = true;
        queue.add(new Point(0, 0, 0));

        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.remove();
                if (p.row == row - 1 && p.col == col - 1) {
                    System.out.println(time);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nowY = p.row + dy[j];
                    int nowX = p.col + dx[j];
                    if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                        continue;
                    }
                    if (!visit[p.skill][nowY][nowX] && road[nowY][nowX] == 0) {
                        queue.add(new Point(p.skill, nowY, nowX));
                        visit[p.skill][nowY][nowX] = true;
                    }
                }
                //말 가능한경우
                if (p.skill < skill) {
                    for (int j = 0; j < 8; j++) {
                        int nowY = p.row + k_dy[j];
                        int nowX = p.col + k_dx[j];
                        if (nowY < 0 || nowY >= row || nowX < 0 || nowX >= col) {
                            continue;
                        }
                        if (!visit[p.skill + 1][nowY][nowX] && road[nowY][nowX] == 0) {
                            queue.add(new Point(p.skill + 1, nowY, nowX));
                            visit[p.skill + 1][nowY][nowX] = true;
                        }
                    }
                }
            }
            time++;
        }
        System.out.println(-1);
    }
}
class Point {

    int skill;
    int row;
    int col;
    Point(int skill, int row, int col) {
        this.skill = skill;
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