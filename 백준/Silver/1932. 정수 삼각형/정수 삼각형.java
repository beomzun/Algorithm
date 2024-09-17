import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[N][N];
        score[0][0] = Integer.parseInt(br.readLine());
        if (N >= 2) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[1][0] = score[0][0] + Integer.parseInt(st.nextToken());
            score[1][1] = score[0][0] + Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    score[i][j] = score[i - 1][j] + Integer.parseInt(st.nextToken());
                    continue;
                }
                if (j == i) {
                    score[i][j] = score[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                    continue;
                }
                score[i][j] = Math.max(score[i - 1][j - 1], score[i - 1][j]) + Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, score[N - 1][i]);
        }

        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
