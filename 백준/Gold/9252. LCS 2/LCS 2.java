import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int row = s1.length();
        int col = s2.length();
        int[][] lcs = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    continue;
                }
                lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }

        if (lcs[row][col] == 0) {
            System.out.println(0);
            return;
        }

        Stack<Character> stack = new Stack<>();
        while (lcs[row][col] != 0) {
            if (lcs[row][col] == lcs[row - 1][col]) {
                row--;
                continue;
            }
            if (lcs[row][col] == lcs[row][col - 1]) {
                col--;
                continue;
            }
            stack.add(s1.charAt(row - 1));
            row--;
            col--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.length() + "\n" + sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}