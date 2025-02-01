import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N + 1];
        int now = 1;
        int last = 1;
        int visitCount = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (visitCount != N) {
            int count = 0;
            while (count != K) {
                if (!visit[now]) {
                    count++;
                }
                last = now;
                now = now % N + 1;
            }
            visit[last] = true;
            visitCount++;
            sb.append(last).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1 2 3 4 5 6 7
 */