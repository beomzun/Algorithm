import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] isWall = new boolean[N][N];
        int[][][] count = new int[N][N][3]; //가로 세로 대각선
        count[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                isWall[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (isWall[i][j]) {
                    continue;
                }

                count[i][j][0] = count[i][j - 1][0] + count[i][j - 1][2];
                if (i == 0) {
                    continue;
                }
                count[i][j][1] = count[i - 1][j][1] + count[i - 1][j][2];

                if (isWall[i][j - 1] || isWall[i - 1][j]) {
                    continue;
                }
                count[i][j][2] = count[i - 1][j - 1][0] + count[i - 1][j - 1][1] + count[i - 1][j - 1][2];
            }
        }

        System.out.println(count[N - 1][N - 1][0] + count[N - 1][N - 1][1] + count[N - 1][N - 1][2]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
가로로 들어온 경우 -> 왼칸의 가로 + 대각선
세로로 들어온 경우 -> 위칸의 세로 + 대각선
대각으로 들어온경우 -> 대각의 가로 + 세로 + 대각
 */