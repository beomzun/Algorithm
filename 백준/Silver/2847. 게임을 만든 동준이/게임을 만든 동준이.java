import java.io.*;
import java.util.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (scores[i] < scores[i + 1]) {
                continue;
            }
            count += (scores[i] - scores[i + 1] + 1);
            scores[i] = scores[i + 1] - 1;
        }
        System.out.println(count);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
