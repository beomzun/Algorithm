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
        int best = liquid[0] + liquid[N - 1];
        int left = 0;
        int right = N - 1;
        int[] answer = new int[]{liquid[left], liquid[right]};
        while (left < right) {
            int now = liquid[left] + liquid[right];
            if (Math.abs(now) < Math.abs(best)) {
                answer[0] = liquid[left];
                answer[1] = liquid[right];
                if (now == 0) {
                    break;
                }
                best = now;
            }
            if (now > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
