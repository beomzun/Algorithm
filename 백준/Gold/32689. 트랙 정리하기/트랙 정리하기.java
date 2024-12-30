import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] trash = new int[N];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            trash[i] = val;
        }

        int right = 1;
        int left = N - 1;
        int prevLeft = left;
        while (right < N && trash[right] == 0) {
            right++;
        }
        while (left > 0 && trash[left] == 0) {
            left--;
        }
        if (right == N) {
            System.out.println(0);
            return;
        }
        long walk = 0L;
        while (right < left) {
            int loop = Math.min(trash[right], trash[left]);
            walk += 2L * loop * (right + N - left);
            trash[right] -= loop;
            trash[left] -= loop;
            while (right < N && trash[right] == 0) {
                right++;
            }
            prevLeft = left;
            while (left > 0 && trash[left] == 0) {
                left--;
            }
        }
        if (right == left) {
            walk += right + (long) (trash[right] - 1) * N;
        } else {
            walk -= N - prevLeft;
        }

        System.out.println(walk);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}