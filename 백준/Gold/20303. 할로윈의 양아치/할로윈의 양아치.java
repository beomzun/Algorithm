import java.util.*;
import java.io.*;
class Solution {
    int N;
    int K;
    int[] candies;
    ArrayList<Integer>[] friends;
    boolean[] visit;
    ArrayList<int[]> list;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candies = new int[N+1];
        friends = new ArrayList[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            candies[i] = Integer.parseInt(st.nextToken());
            friends[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        visit = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            int[] answer = dfs(i,candies[i], 1);
            list.add(answer);
        }

        int[] dp = new int[K];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int[] set : list) {
            int sum = set[0];
            int num = set[1];
            for(int i=K-1;i>=num;i--) {
                if(dp[i-num]>=0) {
                    dp[i] = Math.max(dp[i], dp[i-num]+sum);
                }
            }
        }

        int max = 0;
        for(int i=0;i<K;i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public int[] dfs(int now, int sum, int num) {
        int[] answer = {sum,num};
        for(int friend : friends[now]) {
            if(visit[friend]) {
                continue;
            }
            visit[friend] = true;
            answer = dfs(friend,answer[0]+candies[friend], answer[1]+1);
        }

        return answer;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
스브러스가 K명 미만의 아이들에게 사탕을 뺏으며 최대로 뺏을수있는 사탕의양.
 */