import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int size = deque.size();
            int count = 0;
            int target = Integer.parseInt(st.nextToken());
            while (deque.peek() != target) {
                deque.add(deque.remove());
                count++;
            }
            deque.remove();
            sum += Math.min(count, size - count);
        }

        bw.write(sum + "");
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