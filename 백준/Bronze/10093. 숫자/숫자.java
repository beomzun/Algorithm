import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (long cur = a + 1L; cur < b; cur++) {
            count++;
            sb.append(cur);
            sb.append(" ");
        }

        bw.write(count+"\n");
        bw.write(sb.toString());
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
