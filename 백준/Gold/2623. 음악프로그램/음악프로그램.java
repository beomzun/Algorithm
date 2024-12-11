import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] count = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph[now].add(next);
                count[next]++;
                now = next;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int now = q.remove();
            sb.append(now).append("\n");
            for (int next : graph[now]) {
                count[next]--;
                if (count[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] != 0) {
                System.out.println(0);
                return;
            }
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
