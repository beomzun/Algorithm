import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] dp = new int[s.length()][s.length()];
        //기본 유전자부터 탐색
        for(int len=1;len<s.length();len++) {
            for (int start=0;start+len<s.length();start++) {
                int end = start + len;
                if (s.charAt(start) == 'a' && s.charAt(end) == 't'
                        || s.charAt(start) == 'g' && s.charAt(end) == 'c') {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                }
                for (int mid=start;mid<end;mid++) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][mid] + dp[mid + 1][end]);
                }
            }
        }

        System.out.println(dp[0][s.length() - 1]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
at, gc는 KOI 유전자임.
어떤 X가 KOI 유전자라면, aXt, gXc 도 KOI 유전자임
어떤 X와 Y가 KOI 유전자라면, XY도 KOI 유전자임.
KOI 유전자는 DNA 서열 중에서 부분 서열로 구성되어있음. 주어진 서열에서 임의의 위치에 있는 0개 이상의 문자를 삭제해서 얻어짐.
DNA 서열이 주어졌을 때, 최대 길이의 KOI 유전자의 길이를 출력하시오
---
스택 방식의 반례 -> atgactatcatt
 */