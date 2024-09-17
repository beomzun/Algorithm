import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[] times;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N + 1];
        times[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                times[i] = Math.min(Math.min(times[i / 3], times[i / 2]), times[i - 1]) + 1;
            } else if (i % 3 == 0) {
                times[i] = Math.min(times[i / 3], times[i - 1]) + 1;
            } else if (i % 2 == 0) {
                times[i] = Math.min(times[i / 2], times[i - 1]) + 1;
            } else {
                times[i] = times[i - 1] + 1;
            }
        }
        System.out.println(times[N]);
        past();
    }

    public void past() {
        while (N != 1) {
            System.out.print(N + " ");
            if (N % 3 == 0 && N % 2 == 0) {
                if (times[N / 3] == times[N] - 1) {
                    N /= 3;
                    continue;
                }
                if (times[N / 2] == times[N] - 1) {
                    N /= 2;
                    continue;
                }
                N -= 1;
                continue;
            }
            if (N % 3 == 0) {
                if (times[N / 3] == times[N] - 1) {
                    N /= 3;
                    continue;
                }
                N -= 1;
                continue;
            }
            if (N % 2 == 0) {
                if (times[N / 2] == times[N] - 1) {
                    N /= 2;
                    continue;
                }
                N -= 1;
                continue;
            }
            N -= 1;
        }
        System.out.println(1);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
