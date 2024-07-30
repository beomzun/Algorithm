import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            stack.add(tmp);
            set.add(tmp);
        }

        int count = 0;
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            if (set.contains(x - tmp)) {
                count++;
            }
        }

        bw.write(count / 2 + "");
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
