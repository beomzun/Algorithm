import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] score = new int[2][n];
        score[0][0] = arr[0];
        score[1][0] = 0;
        if (n != 1) {
            score[0][1] = arr[0] + arr[1];
            score[1][1] = arr[0];
        }
        for (int i = 2; i < n; i++) {
            score[0][i] = Math.max(score[1][i - 2] + arr[i - 1], score[0][i - 2]) + arr[i];
            score[1][i] = score[0][i - 1];
        }
        bw.write(String.valueOf(score[0][n-1]));
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