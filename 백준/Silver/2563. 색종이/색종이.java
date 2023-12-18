import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean[][] ar = new boolean[100][100];
        int n = Integer.parseInt(br.readLine());
        int size = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s);
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            for (int j = row; j < row + 10; j++) {
                for (int k = col; k < col + 10; k++) {
                    if (ar[j][k]) {
                        continue;
                    }
                    ar[j][k] = true;
                    size += 1;
                }
            }
        }
        bw.write(String.valueOf(size));
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
