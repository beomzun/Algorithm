import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] is = new boolean[2000001];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            is[val + 1000000] = true;
        }

        int count = 0;
        int idx = 2000000;
        while (count != n) {
            if (is[idx]) {
                bw.write(idx - 1000000 + "\n");
                count++;
            }
            idx--;
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
