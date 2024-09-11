import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            String s = st.nextToken();

            long val = getReverseVal(s);
            pq.add(val);
        }

        while (!pq.isEmpty()) {
            bw.write(pq.remove() + "\n");
        }
        bw.flush();
        bw.close();
    }

    private long getReverseVal(String s) {
        boolean start = false;

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            stack.add(s.charAt(j));
        }
        while(!stack.isEmpty()) {
            char tmp = stack.pop();
            if (tmp != '0') {
                start = true;
            }
            if (start) {
                sb.append(tmp);
            }
        }

        return Long.parseLong(sb.toString());
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}