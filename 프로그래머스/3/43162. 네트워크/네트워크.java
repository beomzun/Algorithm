import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++) {
            if(visit[i]) {
                continue;
            }
            visit[i]=true;
            answer++;
            
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            while(!q.isEmpty()) {
                int now = q.remove();
                for(int j=0;j<n;j++) {
                    if(!visit[j] && computers[now][j]==1) {
                        visit[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        
        return answer;
    }
}
/*
컴퓨터 개수 n
연결정보 배열
i,j 연결시 배열[i][j]=1
*/