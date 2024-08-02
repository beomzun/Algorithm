import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        int result = 0;
        int multiple = 1;
        boolean error = false;
        Stack<Character> stack = new Stack<>();
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case'(':
                    stack.add(c);
                    multiple *= 2;
                    break;
                case')':
                    if(stack.isEmpty() || !stack.peek().equals('(')) {
                        error = true;
                        break;
                    }
                    if (prev == '(') {
                        result += multiple;
                    }
                    stack.pop();
                    multiple /= 2;
                    break;
                case'[':
                    stack.add(c);
                    multiple *= 3;
                    break;
                case']':
                    if(stack.isEmpty() || !stack.peek().equals('[')) {
                        error = true;
                        break;
                    }
                    if (prev == '[') {
                        result += multiple;
                    }
                    stack.pop();
                    multiple /= 3;
                    break;
            }
            if (error) {
                break;
            }
            prev = c;
        }
        if (error || !stack.isEmpty()) {
            bw.write(0 + "");
        } else {
            bw.write(result + "");
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