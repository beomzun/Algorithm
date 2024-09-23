import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static ArrayList<Integer>[] town;
    static ArrayList<Integer> far;
    static int dis;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        town = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            town[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            town[a].add(b);
            town[b].add(a);
        }

        far = new ArrayList<>();
        bfs();
        Collections.sort(far);

        System.out.println(far.get(0) + " " + dis + " " + far.size());
    }

    public void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;

        dis = 1;
        int count = N - 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int val = q.remove();
                for (int next : town[val]) {
                    if (visit[next]) {
                        continue;
                    }
                    visit[next] = true;
                    count--;
                    q.add(next);
                    far.add(next);

                    if (count == 0) {
                        return;
                    }
                }
            }
            far.clear();
            dis++;
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
