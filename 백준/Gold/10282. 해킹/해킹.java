import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //컴퓨터 수
            int D = Integer.parseInt(st.nextToken());   //의존성 수
            int C = Integer.parseInt(st.nextToken());   //해킹시작번호

            ArrayList<int[]>[] graph = new ArrayList[N + 1];
            for(int i=1;i<=N;i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i=0;i<D;i++) {
                st = new StringTokenizer(br.readLine());
                //a가 b의존하며 b감염시 s초후 a감염
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }

            int[] dis = new int[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[C] = 0;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(C);
            while(!q.isEmpty()) {
                int now = q.remove();
                for (int[] edge : graph[now]) {
                    if (dis[now] + edge[1] < dis[edge[0]]) {
                        dis[edge[0]] = dis[now] + edge[1];
                        q.add(edge[0]);
                    }
                }
            }

            int count = 0;
            int max = 0;
            for(int i=1;i<=N;i++) {
                if (dis[i] != Integer.MAX_VALUE) {
                    count++;
                    max = Math.max(max, dis[i]);
                }
            }
            sb.append(count).append(" ").append(max).append("\n");
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
/*

 */