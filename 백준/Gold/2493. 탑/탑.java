import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int high = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.add(high);
                    map.put(high, i);
                    break;
                } else {
                    if(stack.peek() > high) {
                        sb.append(map.get(stack.peek())).append(" ");
                        stack.add(high);
                        map.put(high, i);
                        break;
                    }
                    stack.pop();
                }
            }
        }
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