import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;

            while(st.hasMoreTokens()) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    count++;
                }
            }

            switch (count) {
                case 0:
                    bw.write("E\n");
                    break;
                case 1:
                    bw.write("A\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("C\n");
                    break;
                case 4:
                    bw.write("D\n");
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
