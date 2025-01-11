import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= s.length(); j++) {
                S.add(s.substring(0, j));
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (S.contains(br.readLine())) {
                count++;
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
