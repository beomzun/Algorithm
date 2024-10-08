import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] square = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0) {
                    if (square[i][j] == 1) {
                        max = Math.max(max, square[i][j]);
                    }
                    continue;
                }
                if (square[i][j] > 0) {
                    int min = Math.min(square[i - 1][j - 1], Math.min(square[i - 1][j], square[i][j - 1]));
                    square[i][j] = min + 1;
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
