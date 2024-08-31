import java.util.*;
import java.io.*;
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<Integer> set = new HashSet<>();

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            modifySet();
        }

        bw.flush();
        bw.close();
    }

    public void modifySet() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String comm = st.nextToken();
        if (comm.equals("all")) {
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
            return;
        }
        if (comm.equals("empty")) {
            set.clear();
            return;
        }

        int val = Integer.parseInt(st.nextToken());
        if (comm.equals("add")) {
            if (set.contains(val)) {
                return;
            }
            set.add(val);
            return;
        }
        if (comm.equals("remove")) {
            if (!set.contains(val)) {
                return;
            }
            set.remove(val);
            return;
        }
        if (comm.equals("check")) {
            if (set.contains(val)) {
                bw.write(1 + "\n");
                return;
            }
            bw.write(0 + "\n");
            return;
        }
        if (comm.equals("toggle")) {
            if (set.contains(val)) {
                set.remove(val);
                return;
            }
            set.add(val);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
