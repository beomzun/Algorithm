import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            stack.add(c);
            if (c == bomb.charAt(bomb.length() - 1) && stack.size() >= bomb.length()) {
                boolean match = true;
                for (int i = 0; i < bomb.length(); i++) {
                    if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int i = 0; i < bomb.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
String - 불변 객체이므로 지속해서 새로운 객체 생성됨.
스택의 인덱스는 쌓인 순서임. 마지막에 들어간 객체에 대한 인덱스는 stack.size()-1
 */