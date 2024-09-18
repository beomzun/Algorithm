import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] friends = new ArrayList[N + 1];
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        visit[1] = true;
        q.add(1);
        int result = 0;
        for (int i = 0; i < 2; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int now = q.remove();
                for (int k : friends[now]) {
                    if (!visit[k]) {
                        visit[k] = true;
                        q.add(k);
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
