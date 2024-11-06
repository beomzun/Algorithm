import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);

        if (liquid[0] >= 0) {
            System.out.println(liquid[0] + " " + liquid[1] + " " + liquid[2]);
        }
        if (liquid[N - 1] <= 0) {
            System.out.println(liquid[N - 3] + " " + liquid[N - 2] + " " + liquid[N - 1]);
        }

        int[] answer = new int[3];
        long result = Long.MAX_VALUE;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                long sum = liquid[i] + liquid[left] + liquid[right];
                if (sum == 0) {
                    System.out.println(liquid[i] + " " + liquid[left] + " " + liquid[right]);
                    return;
                }
                if (Math.abs(sum) < Math.abs(result)) {
                    result = sum;
                    answer[0] = i;
                    answer[1] = left;
                    answer[2] = right;
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(liquid[answer[0]] + " " + liquid[answer[1]] + " " + liquid[answer[2]]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
