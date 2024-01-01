import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] arr = new int[y][x];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] tmp;
        int nowY, nowX;
        int nextY, nextX;
        int day = 0;
        while (!queue.isEmpty()) {
            tmp = queue.remove();
            nowY = tmp[0];
            nowX = tmp[1];
            day = arr[nowY][nowX];
            for (int i = 0; i < 4; i++) {
                nextY = nowY + dy[i];
                nextX = nowX + dx[i];
                if (nextY < 0 || nextY >= y || nextX < 0 || nextX >= x) {
                    continue;
                }
                if (arr[nextY][nextX] == 0) {
                    arr[nextY][nextX] = arr[nowY][nowX] + 1;
                    queue.add(new int[]{nextY, nextX});
                }
//                else if (arr[nextY][nextX] > 1) {
//                    arr[nextY][nextX] = Math.min(arr[nextY][nextX], arr[nowY][nowX] + 1);
//                }
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] == 0) {
                    bw.write(String.valueOf(-1));
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write(String.valueOf(day - 1));
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}