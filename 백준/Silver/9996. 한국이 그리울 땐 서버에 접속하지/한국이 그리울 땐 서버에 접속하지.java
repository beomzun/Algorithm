import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        StringBuilder sb = new StringBuilder();
        String[] patterns = pattern.split("\\*");
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.startsWith(patterns[0])) {
                s = s.substring(patterns[0].length());
                if (s.endsWith(patterns[1])) {
                    sb.append("DA\n");
                    continue;
                }
            }
            sb.append("NE\n");
        }
        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
