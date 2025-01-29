import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> broke = new HashSet<>();
        Set<Integer> ready = new TreeSet<>();
        for (int i = 0; i < S; i++) {
            broke.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int r = Integer.parseInt(st.nextToken());
            if (broke.contains(r)) {
                broke.remove(r);
                continue;
            }
            ready.add(r);
        }

        for (int r : ready) {
            if (broke.contains(r - 1)) {
                broke.remove(r - 1);
                continue;
            }
            if (broke.contains(r + 1)) {
                broke.remove(r + 1);
            }
        }

        System.out.println(broke.size());
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
