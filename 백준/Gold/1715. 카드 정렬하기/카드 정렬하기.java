import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0L;
        long inSum = 0L;
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        if (n == 1) {
            bw.write(String.valueOf(0));
        } else if (n == 2) {
            bw.write(String.valueOf(pq.remove() + pq.remove()));
        } else {
            while (pq.size() != 1) {
                inSum = pq.remove() + pq.remove();
                sum += inSum;
                pq.add(inSum);
            }
            bw.write(String.valueOf(sum));
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