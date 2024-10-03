import java.util.*;
import java.io.*;
class Solution {
    static long MOD = 10007;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] asc = new long[N + 1][10];
        Arrays.fill(asc[1], 1L);
        for (int i = 2; i <= N; i++) {
            asc[i][0] = 1L;
            for (int j = 1; j < 10; j++) {
                asc[i][j] = (asc[i][j - 1] + asc[i - 1][j]) % MOD;
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + asc[N][i]) % MOD;
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
/*
1 0~9 => 10개 => 1 1 1 1 1 1 1 1 1 1
2 / 0-0~9 1-1~9 ..8-8~9 9-9 => 55개 => 1 2 3 4 5 6 7 8 9 10
3 / 00-0-9 01-1-9..09-9 - 55 + 11-1-9 12-2-9..19-9 - 45 ... 36..1 => 1 + (1+2) + (1+2+3) ..(1..10)
4 /
 */