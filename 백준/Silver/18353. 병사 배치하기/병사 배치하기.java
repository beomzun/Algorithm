import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(arr[i]<arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N-max);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
요구사항 : 가장 긴 내림차순 만들기
이전 값들과 비교해 작으면 해당 위치의 dp값+1
 */