import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int result = 0;
    static int[] arr = new int[3];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr[0] = 1;
        arr[1] = 2;
        if (N < 2) {
            System.out.println(arr[N-1]);
            return;
        }

        fill(2, 2);
        System.out.println(result);
    }
    public void fill(int depth, int idx) {
        if (depth == N) {
            result = arr[idx == 0 ? 2 : idx - 1];
            return;
        }
        int o1 = (idx + 1) % 3;
        int o2 = (idx + 2) % 3;
        arr[idx] = (arr[o1] + arr[o2]) % 10007;
        fill(depth + 1, (idx + 1) % 3);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}