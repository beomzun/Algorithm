import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public static int[][] count = new int[2][41];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        count[0][0] = 1;
        count[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            count[0][i] = count[0][i - 1] + count[0][i - 2];
            count[1][i] = count[1][i - 1] + count[1][i - 2];
        }
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(count[0][num] + " ");
            bw.write(count[1][num] + "\n");
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