import java.util.*;
import java.io.*;
class Solution {
    int max = 0;
    int R;
    int C;
    int[][] board;
    boolean[] visit = new boolean[26];
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    Set<Integer> set = new HashSet<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j) - 'A';
                set.add(board[i][j]);
            }
        }
        dfs(0, 0, 1);

        System.out.println(max);
    }

    public void dfs(int r, int c, int count) {
        int now = board[r][c];
        max = Math.max(max, count);
        if (max == set.size()) {
            return;
        }

        visit[now] = true;
        for (int i = 0; i < 4; i++) {
            int nY = r + dy[i];
            int nX = c + dx[i];
            if (nY < 0 || nY >= R || nX < 0 || nX >= C || visit[board[nY][nX]]) {
                continue;
            }
            dfs(nY, nX, count + 1);
        }
        visit[now] = false;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1 2 1 7 8
3 4 1 9 10
5 6 3 11 12
 */