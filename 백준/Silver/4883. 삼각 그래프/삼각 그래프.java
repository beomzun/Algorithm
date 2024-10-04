import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int time = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] ladder = new int[N][3];
            int[][] minSum = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            minSum[0][2] = ladder[0][1] + ladder[0][2];
            minSum[1][0] = ladder[0][1] + ladder[1][0];
            minSum[1][1] = Math.min(Math.min(ladder[0][1], minSum[1][0]), minSum[0][2]) + ladder[1][1];
            minSum[1][2] = Math.min(Math.min(ladder[0][1], minSum[1][1]), minSum[0][2]) + ladder[1][2];
            for (int i = 2; i < N; i++) {
                minSum[i][0] = Math.min(minSum[i - 1][0], minSum[i - 1][1]) + ladder[i][0];
                minSum[i][1] = Math.min(
                        Math.min(minSum[i][0] - ladder[i][0], minSum[i][0]),
                        minSum[i - 1][2]
                ) + ladder[i][1];
                minSum[i][2] = Math.min(
                        Math.min(minSum[i][1], minSum[i - 1][1]),
                        minSum[i - 1][2]
                ) + ladder[i][2];
            }
            bw.write(time + ". " + minSum[N - 1][1] + "\n");
            time++;
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