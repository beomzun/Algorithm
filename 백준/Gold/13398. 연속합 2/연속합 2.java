import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][N];
        int max = arr[0];
        dp[0][0] = dp[1][0] = arr[0];
        for(int i=1;i<N;i++) {
            //지금 포함 제거X
            dp[0][i] = Math.max(dp[0][i - 1] + arr[i], arr[i]);
            //지금 포함 제거O
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }
        
        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
음수를 제외한 양수 덩어리 합침.
+ - + - + - + => 여기서 가운데 음수는 여러개일수 있음.
base는 첫 양수.
두번째부터 제거안하는 경우 -> 이전까지 제거안한값 + 가운데 음수들 + 2번 vs 그냥 2번 / 제거하는경우 -> 이전까지제거한값+음수들+2 vs 이전까지제거안한값+하나제거+2
세번째는 2번덩이까지 했을때의 최대값. 근데 가운데 제거햇을 경우와 아닌 경우 분리해서. -> 제거안한경우는 3 + 2까지제거o / 제거한경우는 2까지 제거안한경우+3 vs 2까지제거안한경우 + 가운데 음수들 + 3
---
모두 음수인 경우..
---
10
1 -1 1 -1 1 -1 1 -1 1 -1
---
덩어리로 괜히 묶었나..로직은 파악했는데
 */