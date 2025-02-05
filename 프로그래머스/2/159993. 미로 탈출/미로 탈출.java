import java.util.*;
class Solution {
    int row;
    int col;
    boolean[][] visit;
    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        visit = new boolean[row][col];
        
        int sY=0;
        int sX=0;
        int lY=0;
        int lX=0;
        int eY=0;
        int eX=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                char c = maps[i].charAt(j);
                if(c=='S') {
                    sY=i;
                    sX=j;
                } else if(c=='L') {
                    lY=i;
                    lX=j;
                } else if(c=='E') {
                    eY=i;
                    eX=j;
                }
            }
        }
        
        int answer = 0;
        int time = bfs(sY,sX,lY,lX, maps);
        System.out.println(time);
        if(time==-1) {
            return -1;
        }
        for(int i=0;i<row;i++) {
            Arrays.fill(visit[i], false);
        }
        answer+=time;
        
        time = bfs(lY,lX,eY,eX, maps);
        if(time==-1) {
            return -1;
        }
        answer+=time;
        System.out.println(time);
        
        return answer;
    }
    
    public int bfs(int sY, int sX, int tY, int tX, String[] maps) {
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        int time=1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sY,sX});
        visit[sY][sX]=true;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int[] now = q.remove();
                int nY=now[0];
                int nX=now[1];
                for(int i=0;i<4;i++) {
                    int nextY = nY+dy[i];
                    int nextX = nX+dx[i];
                    if(nextY<0||nextY>=row||nextX<0||nextX>=col||visit[nextY][nextX]||
                       maps[nextY].charAt(nextX)=='X') {
                        continue;
                    }
                    if(nextY==tY&&nextX==tX) {
                        return time;
                    }
                    visit[nextY][nextX]=true;
                    q.add(new int[]{nextY,nextX});
                }
            }
            time++;
        }
        
        return -1;
    }
}
/*
칸 - 벽 통로 레버 문
bfs 두번
*/