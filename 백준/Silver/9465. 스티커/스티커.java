import java.util.*;
import java.io.*;

class Solution {
    static int[][] sticker;
    static int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];
            dp = new int[2][n];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (n == 1) {
                bw.write(Math.max(sticker[0][0], sticker[1][0]) + "\n");
                continue;
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = sticker[0][1] + dp[1][0];
            dp[1][1] = sticker[1][1] + dp[0][0];

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + sticker[1][j];
            }

            bw.write(Math.max(dp[0][n - 1], dp[1][n - 1]) + "\n");
        }

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
/*
입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 n (1 ≤ n ≤ 100,000)이 주어진다.
다음 두 줄에는 n개의 정수가 주어지며, 각 정수는 그 위치에 해당하는 스티커의 점수이다.
연속하는 두 정수 사이에는 빈 칸이 하나 있다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

과정
스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다. 즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.
2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.

출력
각 테스트 케이스 마다, 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값을 출력한다.

해결
dp 사용
 */