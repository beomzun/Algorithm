import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int M;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visit = new boolean[N + 1];
        bw.write(V + " ");
        dfs(V);
        bw.write("\n");

        visit = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(V);
        visit[V] = true;
        while (!q.isEmpty()) {
            int val = q.remove();
            bw.write(val + " ");
            for (int i : graph[val]) {
                if (!visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }

        bw.flush();
        bw.close();
    }

    public void dfs(int val) throws IOException {
        visit[val] = true;
        for (int i : graph[val]) {
            if (!visit[i]) {
                bw.write(i + " ");
                dfs(i);
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
