import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;
        long[] dp = new long[N+1];
        if(N==1) {
            System.out.println(0);
            return;
        }
        dp[0] = dp[1] = 0L;
        dp[2] = 1;
        for(int i=3;i<=N;i++) {
            dp[i] = ((i - 1) * dp[i - 2] + (i - 1) * dp[i - 1]) % mod;
        }

        System.out.println(dp[N]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
0,1 = 0
2 = 1
완전순열
1과 누군가가 맞바꿀때 - (n-1)*dp[n-2]
1은 누군가, 누군가는 나군가를 줄때 - (n-1)*dp[n-1]
---
왜 맞바꿀때 nC2가 아닌 n-1인가?
5명인경우, 12 13 14 15 / 23 24 25 / 34 35 / 45 로 구성
1이 포함되는 경우는 5-1 = 4경우뿐. 나머지는 하위 dp에서 처리하고온다.
 */