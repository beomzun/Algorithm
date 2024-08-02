import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(stack.isEmpty()) {
                    stack.add(c);
                } else {
                    if (stack.peek().equals(c)) {
                        stack.pop();
                    } else {
                        stack.add(c);
                    }
                }
            }
            if(stack.isEmpty()) {
                count++;
            }
        }
        bw.write(count + "");
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