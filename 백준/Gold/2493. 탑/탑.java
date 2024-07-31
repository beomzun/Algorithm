import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int high = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.add(new Pair(i, high));
                    break;
                } else {
                    if(stack.peek().high > high) {
                        sb.append(stack.peek().pos).append(" ");
                        stack.add(new Pair(i, high));
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
class Pair {
    int pos;
    int high;

    Pair(int pos, int high) {
        this.pos = pos;
        this.high = high;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
