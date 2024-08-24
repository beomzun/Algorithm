import java.util.*;
import java.io.*;

class Solution {
    static int max = 0;
    static int N;
    static int M;
    static int[][] board;
    boolean[][] visit;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public void solution() throws IOException {
        input();

        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public void dfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nowY = y + dy[i];
            int nowX = x + dx[i];
            if (nowY < 0 || nowY >= N || nowX < 0 || nowX >= M) {
                continue;
            }

            if (!visit[nowY][nowX]) {
                visit[nowY][nowX] = true;
                if (depth == 2) {
                    dfs(y, x, depth + 1, sum + board[nowY][nowX]);
                }
                dfs(nowY, nowX, depth + 1, sum + board[nowY][nowX]);
                visit[nowY][nowX] = false;
            }
        }
    }
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
테트로미노 종류 5가지. 각각의 경우의 수 -> ㅡ2 ㅁ1 ㄴ8 ㅗ4 ㄹ4 => 19가지 * 최대 25,000칸 => 500,000 경우
=> 너무 복잡함
---
dfs 길이 4탐색 => ㅗ 모양은 다음 좌표 방문표시만 하고 현재좌표에서 dfs 호출
 */