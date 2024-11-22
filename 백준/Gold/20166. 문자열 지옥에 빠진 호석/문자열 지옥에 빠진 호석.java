import java.util.*;
import java.io.*;
class Solution {
    Map<String, Integer> counts = new HashMap<>();
    char[][] board;
    int[] dy = new int[]{-1, 0, 1, 0, -1, 1, 1, -1};
    int[] dx = new int[]{0, -1, 0, 1, -1, -1, 1, 1};
    int N;
    int M;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(i, j, "");
            }
        }

        for (int i = 0; i < K; i++) {
            String s = br.readLine();
            bw.write(counts.getOrDefault(s, 0) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public void bfs(int row, int col, String s) {
        if (s.length() == 6) {
            return;
        }
        String now = s.concat(String.valueOf(board[row][col]));
        counts.put(now, counts.getOrDefault(now, 0) + 1);
        for (int i = 0; i < 8; i++) {
            int nY = row + dy[i];
            if (nY == -1) {
                nY = N - 1;
            } else if (nY == N) {
                nY = 0;
            }

            int nX = col + dx[i];
            if (nX == -1) {
                nX = M - 1;
            } else if (nX == M) {
                nX = 0;
            }

            bfs(nY, nX, now);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();

    }
}
