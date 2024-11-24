import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String startG = st.nextToken();
        String endG = st.nextToken();
        String endS = st.nextToken();
        Set<String> set = new HashSet<>();
        int count = 0;
        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) {
                break;
            }

            st = new StringTokenizer(s);
            String time = st.nextToken();
            String name = st.nextToken();
            if (time.compareTo(startG) <= 0) {
                set.add(name);
            } else if (time.compareTo(endG) >= 0 && time.compareTo(endS) <= 0) {
                if (set.contains(name)) {
                    set.remove(name);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
