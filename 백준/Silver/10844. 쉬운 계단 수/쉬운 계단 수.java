import java.util.*;
import java.io.*;
class Solution {
    static int MOD = 1000000000;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] number = new long[N + 1][10];    // row 번째 자릿수가 col 인 숫자의 개수
        for (int i = 1; i < 10; i++) {
            number[1][i] = 1; // 한 자릿수 1~9를 의미
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    number[i][0] = number[i - 1][1] % MOD;
                } else if (j == 9) {
                    number[i][9] = number[i - 1][8] % MOD;
                } else {
                    number[i][j] = (number[i - 1][j - 1] + number[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;
        for (long val : number[N]) {
            result = (result + val) % MOD;
        }

        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
// 0 0 0 0 0 0 0 0 0 0
// 0 1 1 1 1 1 1 1 1 1
// 1 1 2 2 2 2 2 2 2 1
// ...
/*
0앞에는 1, 9앞에는 8
2차원 배열을 사용하여 자릿수의 값의 개수 표시
 */