import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] man = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            man[i] = st.nextToken().equals("M");
        }

        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(man[u]==man[v]) {
                continue;
            }
            graph[u].add(new int[]{v, d});
            graph[v].add(new int[]{u, d});
        }

        boolean[] visit = new boolean[N+1];
        visit[1] = true;
        int visitCount = N-1;
        int cost = 0;
        Queue<int[]> q = new PriorityQueue<>((e1,e2)->e1[1]-e2[1]);
        q.addAll(graph[1]);
        while(!q.isEmpty()) {
            int[] e = q.remove();
            int num = e[0];
            if(visit[num]) {
                continue;
            }
            visit[num] = true;
            cost += e[1];
            visitCount--;
            if(visitCount==0) {
                break;
            }
            for(int[] neigh : graph[num]) {
                if(visit[neigh[0]]) {
                    continue;
                }
                q.add(neigh);
            }
        }
        if(visitCount!=0) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(cost);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}