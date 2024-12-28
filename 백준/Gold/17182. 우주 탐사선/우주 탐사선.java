import java.util.*;
import java.io.*;
class Solution {
    int N;
    int[][] dis;
    boolean[] visit;
    int result = Integer.MAX_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dis = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dis[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        visit = new boolean[N];
        visit[K] = true;
        dfs(0, K, 0);

        System.out.println(result);
    }
    public void dfs(int depth, int start, int sum) {
        if (depth == N - 1) {
            result = Math.min(result, sum);
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(depth + 1, i, sum + dis[start][i]);
            visit[i] = false;
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
플로이드 워셜 + 백트래킹
 */