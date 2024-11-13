import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = numbers[0];
        int count = 0;
        while (right < N) {
            if (sum <= M) {
                if (sum == M) {
                    count++;
                }
                right++;
                if (right == N) {
                    break;
                }
                sum += numbers[right];
            } else {
                sum -= numbers[left++];
                if (left == N) {
                    break;
                }
                if (left > right) {
                    sum += numbers[++right];
                }
            }
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
