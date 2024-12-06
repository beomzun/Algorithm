import java.util.*;
import java.io.*;
class Solution {
    Set<Integer>[] graph;
    boolean[] visit;
    int cutCount = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new Set[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visit = new boolean[N + 1];
        int chunk = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }
            chunk++;
            visit[i] = true;
            dfs(i, 0);
        }

        System.out.println(cutCount / 2 + chunk - 1);
    }
    public void dfs(int now, int parent) {
        for (int next : graph[now]) {
            if (visit[next]) {
                if (next == parent) {
                    continue;
                }
                cutCount++;
                continue;
            }
            visit[next] = true;
            dfs(next, now);
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
dfs하다가 이전에 방문한 녀석 만나면 끊기
모든 노드에 대해 dfs가 끝나면 덩어리 수만큼 다리 만들기.
끊은 수 + (덩어리-1 = 다리 만드는 수)
 */