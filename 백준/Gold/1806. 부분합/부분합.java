import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        long sum = nums[0];
        while (right < N) {
            if (sum >= S) {
                length = Math.min(length, right - left + 1);
                sum -= nums[left++];
                if (left > right) {
                    right++;
                    if (right == N) {
                        break;
                    }
                    sum += nums[right];
                }
            } else {
                right++;
                if (right == N) {
                    break;
                }
                sum += nums[right];
            }
        }

        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
