import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean error = false;
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                switch (tmp) {
                    case '(', '[':
                        stack.add(tmp);
                        break;
                    case ')':
                        if (stack.isEmpty() || !stack.peek().equals('(')) {
                            error = true;
                        } else {
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || !stack.peek().equals('[')) {
                            error = true;
                        } else {
                            stack.pop();
                        }
                        break;
                    default:
                }
                if (error) {
                    break;
                }
            }
            if (error || !stack.isEmpty()) {
                bw.write("no\n");
            } else {
                bw.write("yes\n");
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