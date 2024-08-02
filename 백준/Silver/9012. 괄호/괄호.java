import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            boolean error = false;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '(':
                        stack.add(c);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek().equals(')')) {
                            error = true;
                            break;
                        }
                        stack.pop();
                }
            }
            if(error || !stack.isEmpty()) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
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