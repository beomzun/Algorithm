import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            for (int j = 2 * (n - i); j >= 1; j--) {
                sb.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 1; i < n; i++) {
            for (int j = n - i; j >= 1; j--) {
                sb.append("*");
            }
            for (int j = 1; j <= 2 * i; j++) {
                sb.append(" ");
            }
            for (int j = n - i; j >= 1; j--) {
                sb.append("*");
            }
            sb.append("\n");
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