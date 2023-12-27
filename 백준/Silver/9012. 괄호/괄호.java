import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < caseCount; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(")")) {
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        bw.write("NO\n");
                        break;
                    }
                } else {
                    stack.push("(");
                }
                if (stack.empty() && j == arr.length - 1) {
                    bw.write("YES\n");
                }
            }
            if (!stack.empty()) {
                bw.write("NO\n");
            }
            stack.clear();
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