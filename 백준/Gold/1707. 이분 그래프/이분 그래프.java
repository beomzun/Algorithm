import java.util.*;
import java.io.*;
class Solution {
    static BufferedWriter bw;
    static int V;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int v = 1; v <= V; v++) {
                graph[v] = new ArrayList<>();
            }
            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            visit = new boolean[V + 1];
            bw.write(confirmGraph() + "\n");
        }
        bw.flush();
        bw.close();
    }

    public String confirmGraph() {
        for (int i = 1; i <= V; i++) {
            if (!visit[i]) {
                if (!bfs(i)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public boolean bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        boolean[] where = new boolean[V + 1];
        boolean left = false;
        where[start] = left;

        while(!q.isEmpty()) {
            int now = q.remove();
            for (int next : graph[now]) {
                if (visit[next]) {
                    if (where[next] == where[now]) {
                        return false;
                    }
                } else {
                    visit[next] = true;
                    where[next] = !where[now];
                    q.add(next);
                }
            }
        }
        return true;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
주어진 그래프가 한 덩이가 아닐 경우 간과함
 */