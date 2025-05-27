import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num==now) {
                now++;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()==now) {
                stack.pop();
                now++;
            }
            stack.add(num);
        }
        while(!stack.isEmpty() && stack.peek()==now) {
            stack.pop();
            now++;
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*

 */