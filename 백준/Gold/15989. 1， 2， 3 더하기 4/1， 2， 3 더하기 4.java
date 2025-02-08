import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max=0;
        for(int i=0;i<T;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i],max);
        }
        max = Math.max(max,3);

        int[] dp = new int[max+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=max;i++) {
            dp[i] = dp[i-3]+1 + i/2;
        }

        StringBuilder sb = new StringBuilder();
        for(int val : arr) {
            sb.append(dp[val]).append("\n");
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
양수
1
2 11
3 21 111
31 22 211 1111
32 311 221 2111 11111
33 321 3111 222 2211 21111 111111
331 322 3211 31111 / 2221 22111 211111 2,5로 나눔. / 1111111

2222
22211
221111
2111111

10
3331(3+7) (2+8) (1+9)
 */