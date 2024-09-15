import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N + 1];
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
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
DP를 사용하여 1부터 거꾸로 자신에게 올 수중 가장 가까운 횟수 찾기
 */