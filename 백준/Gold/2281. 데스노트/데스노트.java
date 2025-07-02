import java.util.*;
import java.io.*;
class Solution {
    int N;
    int M;
    int[] arr;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N][M + 2];
        for(int i=0;i<N;i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));

    }

    public int dfs(int idx, int count) {
        if(idx==N) {
            return 0;
        }

        if (dp[idx][count] != -1) {
            return dp[idx][count];
        }

        int res = Integer.MAX_VALUE;

        //이어서 작성할수있다면
        if (count + arr[idx] <= M) {
            res = Math.min(res, dfs(idx + 1, count + arr[idx] + 1));
        }

        //다음줄로 넘겼다면
        res = Math.min(res, dfs(idx + 1, arr[idx] + 1) + (int) Math.pow(M - count + 1, 2));

        dp[idx][count] = res;

        return res;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N명의 이름을 순서대로 적어야한다. 한 줄에 이어서 적을 경우 한칸띄고 적는다.
마지막 줄을 제외한 모든 줄의 여분 끝칸수 제곱의 최소값을 구하라
---
이어서 쓰기 \ 다음줄에서 쓰기

i번째 단어가 몇자리 차지했을때의 제곱최소값 메모이제이션
 */