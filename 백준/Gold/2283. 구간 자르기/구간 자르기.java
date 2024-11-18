import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] lines = new int[1_000_001];
        long sum = 0L;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sum += (end - start);
            //0 10 이면 0-9에 표시.
            for (int j = start + 1; j <= end; j++) {
                lines[j]++;
            }
        }
        int left = 0;
        int right = 1_000_000;
        while (sum > K && right >= 0) {
            sum -= lines[right];
            right--;
        }
        boolean isAnswer = false;
        while (sum == K) {
            isAnswer = true;
            sum -= lines[right];
            right--;
        }
        if (isAnswer) {
            right++;
            System.out.println(left + " " + right);
            return;
        }

        while (left < 1_000_000) {
            sum -= lines[left++];
            while (sum < K) {
                right++;
                if (right == 1_000_001) {
                    System.out.println(0 + " " + 0);
                    return;
                }
                sum += lines[right];
            }
            if (sum == K) {
                left--;
                System.out.println(left + " " + right);
                return;
            }
        }
        System.out.println(0 + " " + 0);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
----
 ---
  --
 --

1210
0013
 */