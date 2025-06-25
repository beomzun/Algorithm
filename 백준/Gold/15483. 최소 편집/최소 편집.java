import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0;i<=s1.length();i++) {
            dp[i][0] = i;
        }
        for(int i=0;i<=s2.length();i++) {
            dp[0][i] = i;
        }

        for(int i=0;i<s1.length();i++) {
            for(int j=0;j<s2.length();j++) {
                if(s1.charAt(i)==s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j])) + 1;
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
문자열간 최소거리.
 */