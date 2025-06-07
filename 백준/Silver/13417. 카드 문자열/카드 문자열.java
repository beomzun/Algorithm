import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(N--> 0) {
            br.readLine();
            Deque<Character> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                char c = st.nextToken().charAt(0);

                if(deque.isEmpty()) {
                    deque.add(c);
                }
                else {
                    if(deque.getFirst() >= c) {
                        deque.addFirst(c);
                    }
                    else {
                        deque.addLast(c);
                    }
                }
            }
            while(!deque.isEmpty()) {
                sb.append(deque.poll());
            }
            sb.append("\n");
        }
        System.out.print(sb);
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