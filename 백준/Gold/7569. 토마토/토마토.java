import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[z][y][x];
        boolean[][][] visit = new boolean[z][y][x];
        Queue<int[]> queue = new LinkedList<>();
        int val;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    val = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = val;
                    if (val == 1) {
                        visit[i][j][k] = true;
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        int[] tmp;
        int nowX, nowY, nowZ;
        int nextX, nextY, nextZ;
        int day = 0;
        while (!queue.isEmpty()) {
            tmp = queue.remove();
            nowZ = tmp[0];
            nowY = tmp[1];
            nowX = tmp[2];
            for (int i = 0; i < 6; i++) {
                nextZ = nowZ + dz[i];
                nextY = nowY + dy[i];
                nextX = nowX + dx[i];
                if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y || nextZ < 0 || nextZ >= z) {
                    continue;
                }
                if (arr[nextZ][nextY][nextX] != -1) {
                    if (!visit[nextZ][nextY][nextX]) {
                        visit[nextZ][nextY][nextX] = true;
                        queue.add(new int[]{nextZ, nextY, nextX});
                    }
                    if (arr[nextZ][nextY][nextX] == 0) {
                        arr[nextZ][nextY][nextX] = arr[nowZ][nowY][nowX] + 1;
                    } else {
                        arr[nextZ][nextY][nextX] = Math.min(arr[nextZ][nextY][nextX],
                                arr[nowZ][nowY][nowX] + 1);
                    }
                }
            }
        }
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (arr[i][j][k] == 0) {
                        bw.write(String.valueOf(-1));
                        bw.flush();
                        bw.close();
                        return;
                    } else {
                        day = Math.max(day, arr[i][j][k]);
                    }
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