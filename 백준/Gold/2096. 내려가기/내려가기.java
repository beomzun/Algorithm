import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ladders = new int[N][3];
        int[][] answer = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                ladders[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            answer[i] = Arrays.copyOf(ladders[i], 3);
        }
        for (int i = 1; i < N; i++) {
            answer[i][0] = Math.max(answer[i - 1][0], answer[i - 1][1]) + answer[i][0];
            answer[i][1] = Math.max(answer[i - 1][0], Math.max(answer[i - 1][1], answer[i - 1][2])) + answer[i][1];
            answer[i][2] = Math.max(answer[i - 1][1], answer[i - 1][2]) + answer[i][2];
        }
        int max = Math.max(answer[N - 1][0], Math.max(answer[N - 1][1], answer[N - 1][2]));

        for (int i = 0; i < N; i++) {
            answer[i] = Arrays.copyOf(ladders[i], 3);
        }
        for (int i = 1; i < N; i++) {
            answer[i][0] = Math.min(answer[i - 1][0], answer[i - 1][1]) + answer[i][0];
            answer[i][1] = Math.min(answer[i - 1][0], Math.min(answer[i - 1][1], answer[i - 1][2])) + answer[i][1];
            answer[i][2] = Math.min(answer[i - 1][1], answer[i - 1][2]) + answer[i][2];
        }
        int min = Math.min(answer[N - 1][0], Math.min(answer[N - 1][1], answer[N - 1][2]));

        System.out.println(max + " " + min);
    }

}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1차원 배열에서와 다르게 2차원 배열에서의 clone 시 얕은 복사로 주소 공유함
 */