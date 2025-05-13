import java.util.*;
import java.io.*;
class Solution {
    int[][] fact;
    int[] answer;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] benefits = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            for(int j=1;j<=M;j++) {
                int val = Integer.parseInt(st.nextToken());
                benefits[cost][j] = val;
            }
        }

        int[][] dp = new int[N+1][M+1];
        fact = new int[N+1][M+1];
        for(int i=1;i<=M;i++) {
            for(int j=0;j<=N;j++) {
                for(int k=N-j;k>=0;k--) {
                    if(dp[k][i-1]+benefits[j][i] > dp[j+k][i]) {
                        dp[j+k][i] = dp[k][i-1] + benefits[j][i];
                        fact[j+k][i] = j;
                    }
                }
            }
        }

        answer = new int[M+1];
        dfs(N,M);

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N][M]).append("\n");
        for(int i=1;i<=M;i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    public void dfs(int n, int m) {
        if (m == 0) {
            return;
        }
        answer[m] = fact[n][m];
        dfs(n-answer[m], m-1);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
투자했을때 최대 배당금 구하기.
금액<300, 회사<20
한 회사에 분할투자불가. a회사에 3투자 3투자X 6투자ㅇ
 */