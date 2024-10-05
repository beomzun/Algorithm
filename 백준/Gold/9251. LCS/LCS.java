import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
        Arrays.fill(lcs[0], 0);
        for (int i = 0; i < lcs.length; i++) {
            lcs[i][0] = 0;
        }

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
                    lcs[j][i] = lcs[j - 1][i - 1] + 1;
                } else {
                    lcs[j][i] = Math.max(lcs[j - 1][i], lcs[j][i - 1]);
                }
            }
        }
        System.out.println(lcs[s1.length()][s2.length()]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
  A C A Y K P
C 0 1 1 1 1 1
A 1 1 2 2 2 2
P 1 1 2 2 2 3
C 1 2 2 2 2 3
A 1 2 3 3 3 3
K 1 2 3 3 4 4
 */