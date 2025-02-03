import java.util.*;
class Solution {
    int row;
    int col;
    boolean[][] visit;
    int[] sizes;
    int[] dy = {-1,0,1,0};
    int[] dx = {0,-1,0,1};
    public int solution(int[][] land) {
        row = land.length;
        col = land[0].length;
        visit = new boolean[row][col];
        sizes = new int[col];
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(visit[i][j]||land[i][j]==0) {
                    continue;
                }
                bfs(i,j,land);
            }
        }
        
        int max=0;
        for(int i=0;i<col;i++) {
            max = Math.max(max, sizes[i]);
        }
        return max;
    }
    
    public void bfs(int ii, int jj, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> cols = new HashSet<>();
        visit[ii][jj]=true;
        int count=1;
        q.add(new int[]{ii,jj});
        cols.add(jj);
        while(!q.isEmpty()) {
            int[] now = q.remove();
            for(int i=0;i<4;i++) {
                int nY = now[0]+dy[i];
                int nX = now[1]+dx[i];
                if(nY<0||nY>=row||nX<0||nX>=col||land[nY][nX]==0||visit[nY][nX]) {
                    continue;
                }
                visit[nY][nX]=true;
                count++;
                q.add(new int[]{nY,nX});
                cols.add(nX);
            }
        }
        
        for(int c : cols) {
            sizes[c]+=count;
        }
    }
}
/*
bfs진행. 해당 덩어리가 방문한 열에 덩어리 크기 플러스.
bfs 종료 후 열 반복문 통해 답 추출.
*/