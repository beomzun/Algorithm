import java.util.*;
import java.io.*;
class Solution {
    static long MOD = 1000000009L;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] counts = new long[1000001];
        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 4;
        int T = Integer.parseInt(br.readLine());
        int max = 3;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N > max) {
                for (int i = max + 1; i <= N; i++) {
                    counts[i] = (counts[i - 1] + counts[i - 2] + counts[i - 3]) % MOD;
                }
                max = N;
            }
            bw.write(counts[N] + "\n");
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
1
2 11
3 21 12 111
13 121 112 1111 22 211 31
 */