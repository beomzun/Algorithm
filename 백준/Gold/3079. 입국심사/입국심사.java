import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static long M;
    static int[] time;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(time);

        binary(0, time[N - 1] * M);
    }

    public void binary(long low, long high) {
        if (low <= high) {
            long mid = (low + high) / 2;
            long able = 0;

            for (int i = 0; i < N; i++) {
                able += mid / time[i];
                if (able >= M) {
                    break;
                }
            }

            if (able >= M) {
                binary(low, mid - 1);
            } else {
                binary(mid + 1, high);
            }
        } else {
            System.out.println(high + 1);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
