import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] parentCount = new int[N + 1];
        int[] counts = new int[N + 1];
        counts[N] = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            graph[X].add(new int[]{Y, K});
            parentCount[Y]++;
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        while(!q.isEmpty()) {
            int now = q.remove();
            if(graph[now].isEmpty()) {
                leaves.add(now);
            }
            for(int[] child : graph[now]) {
                int next = child[0];
                int count = child[1];
                counts[next] += counts[now] * count;
                parentCount[next]--;
                if (parentCount[next] == 0) {
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(leaves);
        for(int leaf : leaves) {
            sb.append(leaf).append(" ").append(counts[leaf]).append("\n");
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