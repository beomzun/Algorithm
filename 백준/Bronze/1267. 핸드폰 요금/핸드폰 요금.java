import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // y 30 10 \ m 60 15
        int m = 0;
        int y = 0;
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            y += tmp / 30;
            if (tmp / 30 > 0 || tmp % 30 != 0) {
                y++;
            }
            m += tmp / 60;
            if (tmp / 60 > 0 || tmp % 60 != 0) {
                m++;
            }
        }

        y *= 10;
        m *= 15;

        if (m > y) {
            bw.write("Y " + y);
        } else if (m < y) {
            bw.write("M " + m);
        } else {
            bw.write("Y M " + y);
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