import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int lastIdx = -1;
        char lastC = '+';
        Stack<String> stack = new Stack<>();
        stack.add("0");

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                String val = s.substring(lastIdx + 1, i);
                if (lastC == '+') {
                    stack.add(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(val)));
                } else {
                    stack.add(val);
                }
                lastC = s.charAt(i);
                lastIdx = i;
            }
        }
        String val = s.substring(lastIdx + 1);
        if (lastC == '+') {
            stack.add(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(val)));
        } else {
            stack.add(val);
        }

        int result = 0;
        while (stack.size() != 1) {
            result+=Integer.parseInt(stack.pop());
        }
        result = Integer.parseInt(stack.pop()) - result;
        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
55-50+40 => -35. 정수는 못자름.
A-B -> A 작고 B가 크게, A+B -> 둘다 작게 => A는 항상 작게
84+20+376-92-05+80 => 480-92-05+80
 */