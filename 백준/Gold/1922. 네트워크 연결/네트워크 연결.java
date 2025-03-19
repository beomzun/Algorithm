import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[N+1];  //idx와 0이 1비용
        boolean[] visit = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        int total = 0;
        visit[1] = true;
        Queue<int[]> q = new PriorityQueue<>((e1,e2)-> {
            return e1[1]-e2[1];
        });
        q.addAll(graph[1]);
        while(!q.isEmpty()) {
            int[] e = q.remove();
            int node = e[0];
            int cost = e[1];
            if(visit[node]) {
                continue;
            }
            visit[node] = true;
            for(int[] next : graph[node]) {
                if(visit[next[0]]) {
                    continue;
                }
                q.add(next);
            }
            total += cost;
        }
        System.out.println(total);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
MST
 */