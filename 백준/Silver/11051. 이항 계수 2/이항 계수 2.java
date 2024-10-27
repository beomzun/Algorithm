import java.util.*;
import java.io.*;
class Solution {
    static int MOD = 10_007;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        K = Math.min(K, N - K);
        if (K == 0) {
            System.out.println(1);
            return;
        }
        int[][] pascal = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                pascal[i][j] = (j == 0 || j == i) ? 1 : pascal[i - 1][j - 1] + pascal[i - 1][j];
                pascal[i][j] %= MOD;
            }
        }
        System.out.println(pascal[N][K]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
모듈러 연산으로 인해 나누기 진행시 i!이 comb보다 커지는 경우 발생
nCk = n-1Ck-1 + n-1Ck
 */