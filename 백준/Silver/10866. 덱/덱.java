import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        int val;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            switch (comm) {
                case "push_front":
                    val = Integer.parseInt(st.nextToken());
                    deque.addFirst(val);
                    break;
                case "push_back":
                    val = Integer.parseInt(st.nextToken());
                    deque.add(val);
                    break;
                case "pop_front":
                    val = deque.isEmpty() ? -1 : deque.remove();
                    bw.write(val + "\n");
                    break;
                case "pop_back":
                    val = deque.isEmpty() ? -1 : deque.removeLast();
                    bw.write(val + "\n");
                    break;
                case "size":
                    bw.write(deque.size()+"\n");
                    break;
                case "empty":
                    val = deque.isEmpty() ? 1 : 0;
                    bw.write(val + "\n");
                    break;
                case "front":
                    val = deque.isEmpty() ? -1 : deque.peek();
                    bw.write(val + "\n");
                    break;
                case "back":
                    val = deque.isEmpty() ? -1 : deque.peekLast();
                    bw.write(val + "\n");
            }
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
