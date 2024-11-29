import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> sizes = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                sizes.add(Long.parseLong(st.nextToken()));
            }
            long result = 0L;
            while (sizes.size() > 1) {
                long sum = sizes.remove() + sizes.remove();
                result += sum;
                sizes.add(sum);
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}