import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // row=start / col=end
        boolean[][] palindrome = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            palindrome[i][i] = true;
        }
        if (N > 1) {
            for (int i = 1; i < N; i++) {
                palindrome[i][i + 1] = numbers[i] == numbers[i + 1];
            }
        }
        for (int i = N - 2; i >= 1; i--) {
            for (int j = i + 2; j <= N; j++) {
                palindrome[i][j] = palindrome[i + 1][j - 1] && (numbers[i] == numbers[j]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int val = palindrome[start][end] ? 1 : 0;
            bw.write(val + "\n");
        }
        bw.flush();
        bw.close();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}