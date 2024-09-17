import java.util.*;
import java.io.*;
class Solution {
    static int[][] fib;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        fib = new int[2][41];
        fib[0][0] = fib[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            fib[0][i] = fib[0][i - 1] + fib[0][i - 2];
            fib[1][i] = fib[1][i - 1] + fib[1][i - 2];
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(fib[0][N] + " " + fib[1][N] + "\n");
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