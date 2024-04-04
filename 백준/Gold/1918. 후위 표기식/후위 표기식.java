import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        char tmp;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                bw.write(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    tmp = stack.pop();
                    while (tmp != '(') {
                        bw.write(tmp);
                        tmp = stack.pop();
                    }
                } else {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        while (priority(stack.peek()) >= priority(c)) {
                            bw.write(stack.pop());
                            if (stack.isEmpty()) {
                                break;
                            }
                        }
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
    }

    public int priority(char c) {
        return switch (c) {
            case '(' -> 0;
            case '*', '/' -> 2;
            default -> 1;
        };
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}