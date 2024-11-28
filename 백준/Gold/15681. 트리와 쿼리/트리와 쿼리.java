import java.util.*;
import java.io.*;
class Solution {
    boolean[] visit;
    ArrayList<Integer>[] graph;
    int R;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] counts;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        counts = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }
        visit = new boolean[N + 1];
        dfs(R);
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            bw.write(counts[U] + "\n");
        }
        bw.flush();
    }
    public int dfs(int start) {
        visit[start] = true;
        int count = 1;
        for (int next : graph[start]) {
            if (visit[next]) {
                continue;
            }
            count += dfs(next);
        }
        counts[start] = count;
        return count;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
매 쿼리마다 bfs로 타겟까지 방문하고 거기부터 개수탐색
---
메모리 초과
dfs로 dp?
 */