import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            Set<Integer>[] graph = new Set[N + 1];
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

            int count = 0;
            boolean[] visit = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (visit[i]) {
                    continue;
                }
                Queue<Integer> q = new ArrayDeque<>();
                visit[i] = true;
                q.add(i);
                boolean notTree = false;
                while(!q.isEmpty()) {
                    int now = q.remove();
                    for (int val : graph[now]) {
                        graph[val].remove(now);
                        if (visit[val]) {
                            notTree = true;
                            continue;
                        }
                        visit[val] = true;
                        q.add(val);
                    }
                }
                if (notTree) {
                    continue;
                }
                count++;
            }

            sb.append("Case ").append(test).append(": ");
            if (count == 0) {
                sb.append("No trees.");
            } else if (count == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(count).append(" trees.");
            }
            sb.append("\n");
            test++;
        }
        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
