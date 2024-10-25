import java.util.*;
import java.io.*;
class Solution {
    static int[][] dp;
    static int N;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        //row 자리수, col 제일큰자리 수
        dp = new int[11][10];

        Arrays.fill(dp[1], 1);
        for (int i = 2; i < 11; i++) {
            dp[i][i - 1] = 1;
            for (int j = i; j < 10; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        findNum();
    }

    public void findNum() {
        int count = -1;
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                if (count + dp[i][j] >= N) {
                    System.out.println(makeResult(count, i, j));
                    return;
                }
                count += dp[i][j];
            }
        }
        System.out.println(-1);
    }

    public String makeResult(int count, int i, int j) {
        StringBuilder sb = new StringBuilder();
        if (count + dp[i][j] == N) {
            while (i != 0) {
                sb.append(j--);
                i--;
            }
        } else if (count + dp[i][j] > N) {
            sb.append(j);
            for (int row = i - 1; row > 0; row--) {
                for (int col = 0; col < 10; col++) {
                    if (count + dp[row][col] == N) {
                        while (row != 0) {
                            sb.append(col--);
                            row--;
                        }
                        break;
                    }
                    if (count + dp[row][col] > N) {
                        sb.append(col);
                        break;
                    }
                    count += dp[row][col];
                }
            }
        }
        return sb.toString();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
18
한자리 : 1 1 1 1 1 1 1 1 1 1 9개
두자리 : 0 1 2 3 4 5 6 7 8 9 45개
세자리 : 0 0 1 3 6 10 15 21 28 36
네자리 : 0 0 0 1 4

최대 : 9,876,543,210
---
58
9+45+1+3
---
dp 로직 인덱스 문제 + dp[1][0] 처리 문제
 */