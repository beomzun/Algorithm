import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] path: lighthouse) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }
        
        dp = new int[n+1][2];
        dfs(1,0);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    public void dfs(int root, int parent) {
        dp[root][0]=0;
        dp[root][1]=1;
        
        for(int child : graph[root]) {
            if(child==parent) {
                continue;
            }
            
            dfs(child, root);
            dp[root][0] += dp[child][1];
            dp[root][1] += Math.min(dp[child][1], dp[child][0]);
        }
    }
}
/*
등대 n개 10만. 뱃길 n-1개 => 모든 등대 이동가능.
몇개의 등대만 켜두려함. 뱃길의 양 등대 중 한 곳은 켜있어야함.
등대 개수 최소값.
---
OXXO 불가.
---
남은 자식 수 가장 많은 녀석 끄기. 정렬해두고, 영향받은애 나오면 빼고 다시삽입
---
반례 : A-b-c-d / b-b1 ,c-c1, d-d1 
지금은 A,b1,c1,d1 켜야하지만, 사실은 b,c,d만 키면됨.
이게 트리dp구나.
*/