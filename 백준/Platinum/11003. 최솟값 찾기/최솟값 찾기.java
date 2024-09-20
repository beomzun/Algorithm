import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<int[]> minDeq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        minDeq.add(new int[]{Integer.parseInt(st.nextToken()), 0});
        bw.write(minDeq.getFirst()[0] + " ");

        for (int i = 1; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!minDeq.isEmpty() && minDeq.getLast()[0] > now) {
                minDeq.removeLast();
            }

            minDeq.add(new int[]{now, i});

            if ((i - L) >= 0 && (i - L) >= minDeq.getFirst()[1]) {
                minDeq.removeFirst();
            }
            bw.write(minDeq.getFirst()[0] + " ");
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