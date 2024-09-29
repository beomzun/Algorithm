import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[] numbers = new int[N];
        int[] length = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers[0] = Integer.parseInt(st.nextToken());
        Arrays.fill(length, 1);

        int max = 1;
        for (int i = 1; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    length[i] = Math.max(length[j] + 1, length[i]);
                }
            }
            max = Math.max(max, length[i]);
        }
        System.out.println(max);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
