import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                set.add(i);
            }
        }

        int now = 1;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());
            if (comm == 3) {
                if(set.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                if (set.contains(now)) {
                    bw.write(0 + "\n");
                    continue;
                }

                Integer next = set.higher(now);
                int dis;
                if (next == null) {
                    dis = (N - now) + set.first();
                } else {
                    dis = next - now;
                }
                bw.write(dis + "\n");
            } else {
                int val = Integer.parseInt(st.nextToken());
                if (comm == 1) {
                    if (set.contains(val)) {
                        set.remove(val);
                    } else {
                        set.add(val);
                    }
                } else {
                    val %= N;
                    now += val;
                    if (now > N) {
                        now -= N;
                    }
                }
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