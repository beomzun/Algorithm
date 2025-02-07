import java.util.*;
class Solution {
    Queue<Integer> pq = new PriorityQueue<>();
    boolean[][] visit;
    int row;
    int col;
    
    public int[] solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        visit = new boolean[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(visit[i][j]||maps[i].charAt(j)=='X') {
                    continue;
                }
                pq.add(bfs(i,j,maps));
            }
        }
        
        if(pq.size()==0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[pq.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = pq.remove();
        }
        return answer;
    }
    
    int[] dy = {-1,0,1,0};
    int[] dx = {0,-1,0,1};
    public int bfs(int r, int c, String[] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        visit[r][c]=true;
        int size=Character.getNumericValue(maps[r].charAt(c));
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int nowY = now[0];
            int nowX = now[1];
            for(int i=0;i<4;i++) {
                int nY = nowY+dy[i];
                int nX = nowX+dx[i];
                if(nY<0||nY>=row||nX<0||nX>=col || visit[nY][nX] || maps[nY].charAt(nX)=='X') {
                    continue;
                }
                q.add(new int[]{nY,nX});
                visit[nY][nX]=true;
                size+=Character.getNumericValue(maps[nY].charAt(nX));
            }
        }
        
        return size;
    }
}