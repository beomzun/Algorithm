import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int val;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                val = Integer.parseInt(st.nextToken());
                if(pq.size() < n) {
                    pq.add(val);
                } else if(pq.peek() < val) {
                    pq.remove();
                    pq.add(val);
                }
            }
        }
        bw.write(String.valueOf(pq.peek()));
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