import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] dis = new int[N+1];
        int INF = 300_000;
        Arrays.fill(dis, INF);
        dis[X] = 0;

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        int time = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        while(!q.isEmpty() && time<=K) {
            int size = q.size();
            while(size-->0) {
                int now = q.remove();
                for(int val : graph[now]) {
                    if(dis[val]!=INF) {
                        continue;
                    }
                    dis[val] = time;
                    q.add(val);
                }
            }
            time++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            if(dis[i]==K) {
                list.add(i);
            }
        }

        if(list.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int c : list) {
            sb.append(c).append("\n");
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

