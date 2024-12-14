import java.util.*;
import java.io.*;
class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    int[][] times;
    ArrayList<Integer>[] graph;
    int[] counts;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            times = new int[2][N + 1];
            for (int i = 1; i <= N; i++) {
                times[0][i] = Integer.parseInt(st.nextToken());
            }
            graph = new ArrayList[N + 1];
            counts = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                graph[parent].add(child);
                counts[child]++;
            }

            findTarget();
        }
        System.out.println(sb);
    }
    public void findTarget() throws IOException {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == 0) {
                q.add(i);
            }
        }

        int target = Integer.parseInt(br.readLine());
        while(!q.isEmpty()) {
            int now = q.remove();
            for (int child : graph[now]) {
                times[1][child] = Math.max(times[1][child], times[0][now]);
                counts[child]--;
                if (counts[child] == 0) {
                    times[0][child] += times[1][child];
                    if (child == target) {
                        sb.append(times[0][child]).append("\n");
                        return;
                    }
                    q.add(child);
                }
            }
        }
        sb.append(times[0][target]).append("\n");
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
