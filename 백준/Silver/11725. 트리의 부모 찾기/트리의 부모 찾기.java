import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        visit[1] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        Map<Integer, Integer> parents = new HashMap<>();
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int link : graph[now]) {
                if (visit[link]) {
                    continue;
                }
                parents.put(link, now);
                visit[link] = true;
                q.add(link);
            }
        }
        for (int i = 2; i <= N; i++) {
            bw.write(parents.get(i) + "\n");
        }
        bw.flush();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}