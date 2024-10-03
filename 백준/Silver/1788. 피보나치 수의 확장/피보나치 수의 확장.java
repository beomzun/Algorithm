import java.util.*;
import java.io.*;
class Solution {
    static int MOD = 1000000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0 + "\n" + 0);
            return;
        }
        int absN = Math.abs(N);
        long[] fib = new long[absN * 2 + 1];
        fib[absN] = 0;
        fib[absN + 1] = 1;
        fib[absN - 1] = 1;
        if (N < 0) {
            for (int i = absN - 2; i >= 0; i--) {
                fib[i] = (fib[i + 2] - fib[i + 1]) % MOD;
            }
        } else {
            for (int i = N + 2; i <= 2 * N; i++) {
                fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
            }
        }
        if (N > 0) {
            System.out.println(1 + "\n" + fib[2 * N]);
        } else {
            System.out.println((fib[0] < 0 ? -1 : 1) + "\n" + Math.abs(fib[0]));
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
fib[N] = fib[N-1]+fib[N-2]
5 -3 2 -1 1 0 1 1 2 3 5 
 */