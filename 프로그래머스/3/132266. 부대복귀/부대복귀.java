import java.util.*;
class Solution {
    public int[] solution(int N, int[][] roads, int[] sources, int destination) {
        int people = sources.length;
        int[] dis = new int[N+1];
        int[] answer = new int[people];
        
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        boolean[] visit = new boolean[N+1];
        visit[destination] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(destination);
        int time = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int now = q.remove();
                for(int next : graph[now]) {
                    if(visit[next]) {
                        continue;
                    }
                    visit[next] = true;
                    q.add(next);
                    dis[next] = time;
                }
            }
            time++;
        }
        
        for(int i=0;i<people;i++) {
            answer[i] = dis[sources[i]];
            if(answer[i]==0 && sources[i]!=destination) {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}
/*
각 지역에서 부대로 => 부대에서 각 지역으로 = 다익스트라
*/