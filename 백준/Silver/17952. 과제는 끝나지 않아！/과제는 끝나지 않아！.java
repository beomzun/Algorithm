import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> assignments = new Stack<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                if (assignments.isEmpty()) {
                    continue;
                }
                int[] nowAss = assignments.pop();
                int now = nowAss[0] - 1;
                if (now > 0) {
                    assignments.push(new int[]{now, nowAss[1]});
                } else {
                    result += nowAss[1];
                }
                continue;
            }

            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if (time > 1) {
                assignments.push(new int[]{time - 1, score});
                continue;
            }
            result += score;
        }
        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
