import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] appear = new int[2000001];
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            appear[val + 1000000]++;
        }

        int count = 0;
        int idx = 0;
        while (count != n) {
            for (int i = 0; i < appear[idx]; i++) {
                bw.write(idx - 1000000 + "\n");
                count++;
            }
            idx++;
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
