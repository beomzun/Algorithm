import java.util.*;
class Solution {
    // 가중치 배열, 간선 배열
    public long solution(int[] a, int[][] edges) {
        long[] sums = new long[a.length];
        long total = 0L;
        for(int i=0;i<a.length;i++) {
            sums[i] = a[i];
            total+=a[i];
        }
        if(total!=0) {
            return -1;
        }
        
        ArrayList<Integer>[] graph = new ArrayList[a.length];
        int[] lines = new int[a.length];
        for(int i=0;i<a.length;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            lines[u]++;
            lines[v]++;
        }
        
        boolean[] visit = new boolean[a.length];
        Arrays.fill(visit, false);
        Queue<Integer> q = new ArrayDeque<>();
        // 0부터 하면 도느 두개인 경우 둘다 들어감.
        for(int i=1;i<a.length;i++) {
            if(lines[i]==1) {
                q.add(i);
                visit[i]=true;
            }
        }

        long count = 0L;
        while(!q.isEmpty()) {
            int now = q.remove();
            lines[now]--;
            count += Math.abs(sums[now]);
            for(int neigh : graph[now]) {
                if(visit[neigh]) {
                    continue;
                }
                lines[neigh]--;
                sums[neigh]+=sums[now];
                if(lines[neigh]==1 && neigh!=0) {
                    visit[neigh]=true;
                    q.add(neigh);
                }
                break;
            }
        }
        
        return count;
    }
}
/*
두 점을 골라 한쪽 +1, 한쪽 -1
모든 트리가 가능한 것은 아님.
가능하면 최소한 행동을 통해 진행.
불가하면 -1, 가능하면 최소진행수, 첨부터 모두 0이면 0
-----
노드 수 30만
---
직선이면 dfs 터짐 -> 위상정렬 
*/