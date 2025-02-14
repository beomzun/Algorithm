import java.util.*;
class Solution {
    public int solution(int N, int[][] edges) {
        Set<Integer>[] graph = new Set[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new HashSet<>();
        }
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visit = new boolean[N+1];
        int min = 101;
        for(int[] edge : edges) {
            Arrays.fill(visit,false);
            graph[edge[0]].remove(edge[1]);
            graph[edge[1]].remove(edge[0]);
            
            int count=1;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(1);
            visit[1]=true;
            while(!q.isEmpty()) {
                int now = q.remove();
                for(int next : graph[now]) {
                    if(visit[next]) {
                        continue;
                    }
                    visit[next]=true;
                    count++;
                    q.add(next);
                }
            }
            
            min = Math.min(min, Math.abs(count-(N-count)));
            
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        return min;
    }
    
}