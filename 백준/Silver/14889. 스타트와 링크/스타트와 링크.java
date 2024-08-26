import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[][] board;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public void solution() throws IOException {
        input();
        team(0, 0);
        System.out.println(min);
    }

    public void team(int now, int num) {
        if (num == N / 2) {
            calDiff();
            return;
        }

        for (int i = now; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                team(i+1, num + 1);
                visit[i] = false;
            }
        }
    }

    public void calDiff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start += board[i][j];
                    start += board[j][i];
                    continue;
                }
                if (!visit[i] && !visit[j]) {
                    link += board[i][j];
                    link += board[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));

        if (min == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
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
경우의 수 : NC2 / 2
시간복잡도 : (N/2 -1)! * 2
- 5 9 6
- - 6 10
- - - 7
- - - -
백트래킹으로 팀 구분 -> 팀 완성 시 점수 계산
---
시간초과
- 팀 선택 시 재귀 호출시에 다음 인덱스부터 보도록 수정
 */