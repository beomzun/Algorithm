import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] square = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                square[i][j] = Character.getNumericValue(s.charAt(j-1));
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (square[i][j] == 1) {
                    square[i][j] = Math.min(square[i - 1][j - 1], Math.min(square[i - 1][j], square[i][j - 1])) + 1;
                    max = Math.max(max, square[i][j]);
                }
            }
        }
        System.out.println((int) Math.pow(max, 2));
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
