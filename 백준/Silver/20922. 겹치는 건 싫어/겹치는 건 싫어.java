import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] counts = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int length = 0;
        while (right < N) {
            maxLength = Math.max(maxLength, length);
            int val = arr[right++];
            counts[val]++;
            length++;

            if (counts[val] > K) {
                while (counts[val] > K) {
                    counts[arr[left++]]--;
                    length--;
                }
            }
        }
        maxLength = Math.max(maxLength, length);

        System.out.println(maxLength);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}