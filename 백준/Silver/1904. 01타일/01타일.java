import java.util.*;
import java.io.*;
class Solution {
    static int MOD = 15746;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] floor = new long[N + 1];
        floor[0] = 1;
        floor[1] = 1;
        for (int i = 2; i <= N; i++) {
            floor[i] = (floor[i - 1] + floor[i - 2]) % MOD;
        }
        System.out.println(floor[N]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1
11 00
111 001 100
1111 1100 0011 1001 0000
11111 11001 00111 10011 00001 11100 00100 10000
 */