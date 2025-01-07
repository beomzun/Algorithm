import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v,w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[N+1];
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<int[]> edges = new PriorityQueue<>((e1,e2)->e1[1]-e2[1]);
        edges.add(new int[]{start,0});
        while(!edges.isEmpty()) {
            int[] now = edges.remove();
            int num = now[0];
            int cost = now[1];
            if(visit[num]) {
                continue;
            }
            visit[num]=true;
            dis[num] = cost;
            if(num==end) {
                break;
            }

            for(int[] edge : graph[num]) {
                if(visit[edge[0]]) {
                    continue;
                }
                if(dis[edge[0]] > cost + edge[1]) {
                    dis[edge[0]] = cost+edge[1];
                    edges.add(new int[]{edge[0], dis[edge[0]]});
                }
            }
        }
        System.out.println(dis[end]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
