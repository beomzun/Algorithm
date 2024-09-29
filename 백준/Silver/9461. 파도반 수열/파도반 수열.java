import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] tri = new long[100];
        tri[0] = tri[1] = tri[2] = 1;
        tri[3] = tri[4] = 2;
        for (int i = 5; i < 100; i++) {
            tri[i] = tri[i - 1] + tri[i - 5];
        }

        for (int t = 0; t < T; t++) {
            bw.write(tri[Integer.parseInt(br.readLine()) - 1] + "\n");
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
/*
1 1 1 2 2 3 4 5 7 9 12 16 21 28
 */