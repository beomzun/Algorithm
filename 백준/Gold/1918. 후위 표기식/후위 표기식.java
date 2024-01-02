import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        String val;
        for (int i = 0; i < arr.length; i++) {
            val = arr[i];
            //피연산자
            if (val.compareTo("A") >= 0 && val.compareTo("Z") <= 0) {
                queue.add(val);
            } else {    //연산자   //괄호처리
                if (val.equals("(")) {
                    stack.push(val);
                } else if (val.equals(")")) {
                    while (!stack.empty() && !stack.peek().equals("(")) {
                        queue.add(stack.pop());
                    }
                    stack.pop();
                } else {    //연산자 우선순위
                    if (stack.empty()) {
                        stack.push(val);
                    } else {
                        if (stack.peek().equals("(")) {
                            stack.push(val);
                        } else {
                            if (priority(stack.peek()) < priority(val)) {
                                stack.push(val);
                            } else {
                                while (!stack.empty() && priority(stack.peek()) >= priority(val)) {
                                    queue.add(stack.pop());
                                }
                                stack.push(val);
                            }
                        }
                    }
                }
            }
        }
        while (!stack.empty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            bw.write(queue.remove());
        }
        bw.flush();
        bw.close();
    }

    public static int priority(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else if (operator.equals("(")) {
            return 0;
        } else {
            return 1;
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}