import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] parents = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine()); st.nextToken();
        for (int i = 2; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            parents[parent].add(i);
        }
        int[] good = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            good[target] += value;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()) {
            int now = q.remove();
            for (int child : parents[now]) {
                q.add(child);
                good[child] += good[now];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(good[i]).append(" ");
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