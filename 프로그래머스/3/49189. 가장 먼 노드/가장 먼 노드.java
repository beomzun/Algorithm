import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE/2);
        dis[1]=0;
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        boolean[] visit = new boolean[n+1];
        visit[1]=true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()) {
            int now = q.remove();
            for(int to : graph[now]) {
                if(visit[to]) {
                    continue;
                }
                visit[to]=true;
                dis[to] = Math.min(dis[to], dis[now]+1);
                q.add(to);
            }
        }
        
        int max=0;
        int count=0;
        for(int i=2;i<=n;i++) {
            if(dis[i]>max) {
                max=dis[i];
                count=1;
            } else if(dis[i]==max) {
                count++;
            }
        }
        return count;
    }
}