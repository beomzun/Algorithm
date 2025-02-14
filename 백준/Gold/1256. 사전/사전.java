import java.util.*;
import java.io.*;
class Solution {
    int N;
    int M;
    long K;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //a개수
        M = Integer.parseInt(st.nextToken());   //z개수
        K = Long.parseLong(st.nextToken());   //k번째

        int max = 1_000_000_000;
        long[][] dp = new long[N+M+1][N+M+1];
        dp[0][0]=1;
        for(int i=1;i<=N+M;i++) {
            dp[i][0]=1;
            for(int j=1;j<=i;j++) {
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                dp[i][j] = Math.min(dp[i][j], max+1);
            }
        }

        if(dp[N+M][N]<K) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(N!=0||M!=0) {
            if(dp[N+M-1][M]>=K) {   // 지금 a를 골랐다했을 때 N+M-1개 중에 N-1개를 고르는수가 K이상이면 지금 a가 맞음.
                sb.append("a");
                N--;
            } else {    //그게 아니라 N+M-1개 중에 N-1개를 고르는 수가 K보다 작으면 지금 a를 고르면 안됨.
                sb.append("z");
                K -= dp[N + M - 1][M];
                M--;
            }
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
/*
N개의 a와 M개의 z로 이루어진 문자열. 사전순으로 정렬되어있고, 이 중 K번쨰를 찾아야함.
전체길이는 n+m.
---
해당 위치에서 골랐을때 개수비교후 제외 아이디어는 생각났으나 구현 못햇음
 */