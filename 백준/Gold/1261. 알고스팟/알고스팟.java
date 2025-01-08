import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] room = new boolean[N][M];
        int[][] breakCount = new int[N][M];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                room[i][j] = s.charAt(j) == '1';
                breakCount[i][j] = INF;
            }
        }

        int[] dy = new int[]{-1, 0, 0, 1};
        int[] dx = new int[]{0, -1, 1, 0};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int row = now[0];
            int col = now[1];
            int count = now[2];
            if (room[row][col]) {
                count++;
            }
            if (count >= breakCount[row][col]) {
                continue;
            }
            breakCount[row][col] = count;
            for (int i = 0; i < 4; i++) {
                int nY = row + dy[i];
                int nX = col + dx[i];
                if (nY < 0 || nY >= N || nX < 0 || nX >= M) {
                    continue;
                }
                if (breakCount[nY][nX] > count) {
                    q.add(new int[]{nY, nX, count});
                }
            }
        }

        System.out.println(breakCount[N - 1][M - 1]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
