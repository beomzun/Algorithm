import java.util.*;
import java.io.*;
class Solution {
    ArrayList<Integer>[] graph;
    int[][] dp;
    boolean[] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
            graph[a].add(b);
        }
        dp = new int[2][N + 1];
        visit = new boolean[N + 1];
        dfs(1);

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    public void dfs(int now) {
        visit[now] = true;
        dp[0][now] = 0;
        dp[1][now] = 1;
        for (int child : graph[now]) {
            if (visit[child]) {
                continue;
            }
            dfs(child);
            dp[0][now] += dp[1][child];
            dp[1][now] += Math.min(dp[0][child], dp[1][child]);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
트리의 모양이 회전해도? 결과는 바뀌지 않는다.
엣지를 작은수-큰수로. 작은수가 부모가 되도록. 각 노드별로 층수체크. -> dp
층수가 아니라 노드별 dp
 */