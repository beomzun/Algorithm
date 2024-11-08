import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Integer[] snacks = new Integer[N];
        st = new StringTokenizer(br.readLine());
        long sum = 0L;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            snacks[i] = val;
            sum += val;
        }
        if (sum < M) {
            System.out.println(0);
            return;
        }

        Arrays.sort(snacks, Collections.reverseOrder());

        int min = 1;
        int max = snacks[0] + 1;
        while (min < max) {
            int length = (min + max) / 2;
            int count = 0;
            for (int snack : snacks) {
                count += snack / length;
                if (count >= M) {
                    break;
                }
            }
            if (count >= M) {
                min = length + 1;
            } else {
                max = length;
            }
        }
        System.out.println(min - 1);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
