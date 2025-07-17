import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int cost = 0;
        ArrayList<int[]>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] info : costs) {
            graph[info[0]].add(new int[]{info[1],info[2]});
            graph[info[1]].add(new int[]{info[0],info[2]});
        }
        
        boolean[] visit = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            int[] now = q.remove();
            if(visit[now[0]]) {
                continue;
            }
            visit[now[0]] = true;
            cost +=now[1];
            for(int[] next : graph[now[0]]) {
                if(visit[next[0]]) {
                    continue;
                }
                q.add(next);
            }
        }
        return cost;
    }
}
/*
MST
*/