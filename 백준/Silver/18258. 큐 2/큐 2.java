import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        int val;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            switch (comm) {
                case "push":
                    val = Integer.parseInt(st.nextToken());
                    queue.add(val);
                    break;
                case "pop":
                    val = queue.isEmpty() ? -1 : queue.pop();
                    bw.write(val + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    val = queue.isEmpty() ? 1 : 0;
                    bw.write(val + "\n");
                    break;
                case "front":
                    val = queue.isEmpty() ? -1 : queue.peekFirst();
                    bw.write(val + "\n");
                    break;
                case "back":
                    val = queue.isEmpty() ? -1 : queue.getLast();
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
