import java.util.*;
class Solution {
    public int solution(String[] board) {
        int row = board.length;
        int col = board[0].length();
        boolean[][][] visit = new boolean[row][col][4];
        int startY=0;
        int startX=0;
        int targetY=0;
        int targetX=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i].charAt(j)=='R') {
                    startY=i;
                    startX=j;
                    continue;
                }
                if(board[i].charAt(j)=='G') {
                    targetY=i;
                    targetX=j;
                }
            }
        }
        //---
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        
        int time=1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startY,startX});
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s=0;s<size;s++) {
                int[] now = q.remove();
                int nowY = now[0];
                int nowX = now[1];
                for(int i=0;i<4;i++) {
                    int nY = nowY;
                    int nX = nowX;
                    while(nY>=0&&nY<row&&nX>=0&&nX<col) {
                        nY+=dy[i];
                        nX+=dx[i];
                        if(nY>=0&&nY<row&&nX>=0&&nX<col&& board[nY].charAt(nX)=='D') {
                            visit[nY][nX][i]=true;
                            break;
                        }
                    }
                    nY-=dy[i];
                    nX-=dx[i];
                    if(board[nY].charAt(nX)=='G') {
                        return time;
                    }
                    if(!visit[nowY][nowX][i]) {
                        visit[nowY][nowX][i] = true;
                        q.add(new int[]{nY,nX});
                    }
                }
            }
            time++;
        }
        return -1;
    }
}