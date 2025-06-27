import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                sb.append(s.charAt(i));
                continue;
            }
            //마지막이 아니고 다음문자가 (라면 배수역할임.
            if(i<s.length()-1 && s.charAt(i+1)=='(') {
                sb.append(s.charAt(i));
            } else {
                sb.append(1);
            }
        }
        String rep = sb.toString();

        Stack<String> stack = new Stack<>();
        for(int i=0;i<rep.length();i++) {
            if (rep.charAt(i) != ')') {
                stack.push(String.valueOf(rep.charAt(i)));
            } else {
                int len = 0;
                while (!stack.peek().equals("(")) {
                    len += Integer.parseInt(stack.pop());
                }
                stack.pop();    // ( 빼기
                len *= Integer.parseInt(stack.pop());
                stack.push(String.valueOf(len));
            }
        }

        int answer = 0;
        while(!stack.isEmpty()) {
            answer += Integer.parseInt(stack.pop());
        }

        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
스택 사용 -> ()중점으로. 닫는괄호나오면 여는괄호 나올때까지 제거. 그리고 이어서 나온 정수만큼 길이 곱하기.
길이가 너무 길어지니까 문자열대신 길이로 표시.

13(112(11(1)))
13(114) / 13(6) / 19
 */