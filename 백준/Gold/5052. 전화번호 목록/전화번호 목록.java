import java.io.*;
import java.util.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] list = new String[n];
            boolean b = true;
            for (int j = 0; j < n; j++) {
                list[j] = br.readLine();
            }
            Arrays.sort(list);
            for (int j = 1; j < n; j++) {
                if (list[j].startsWith(list[j - 1])) {
                    bw.write("NO\n");
                    b = false;
                    break;
                }
            }
            if (b) {
                bw.write("YES\n");
            }
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