import java.util.*;
import java.io.*;
class Solution {
    static int[] time;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        time = new int[100001];
        Arrays.fill(time, -1);
        Queue<Integer> queue = new LinkedList<>();
        time[start] = 0;
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.remove();
            if (now == end) {
                System.out.println(time[end]);
                return;
            }

            int port = now * 2;
            if (port >= 0 && port <= 100000 && time[port] == -1) {
                time[port] = time[now];
                queue.add(port);
            }

            int prev = now - 1;
            if (prev >= 0 && prev <= 100000 && time[prev] == -1) {
                time[prev] = time[now] + 1;
                queue.add(prev);
            }
            //4 \ 835 \ 16 7 9 \ 6 2
            int next = now + 1;
            if (next >= 0 && next <= 100000 && time[next] == -1) {
                time[next] = time[now] + 1;
                queue.add(next);
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
