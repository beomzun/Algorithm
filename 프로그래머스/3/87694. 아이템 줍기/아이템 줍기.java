import java.util.*;
class Solution {
    int[] dy = new int[]{-1,0,1,0};
    int[] dx = new int[]{0,-1,0,1};
    public int solution(int[][] rectangle, int cX, int cY, int itemX, int itemY) {
        boolean[][] line = new boolean[102][102];
        
        // 채우기
        for(int[] rec : rectangle) {
            int lX = rec[0];
            int lY = rec[1];
            int rX = rec[2];
            int hY = rec[3];
            for(int i=lX*2;i<=rX*2;i++) {
                for(int j=lY*2;j<=hY*2;j++) {
                    line[j][i] = true;
                }
            }
        }
        
        // 지우기
        for(int[] rec : rectangle) {
            int lX = rec[0];
            int lY = rec[1];
            int rX = rec[2];
            int hY = rec[3];
            for(int i=lX*2+1;i<rX*2;i++) {
                for(int j=lY*2+1;j<hY*2;j++) {
                    line[j][i] = false;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{cY*2,cX*2});
        
        int dis = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int[] now = q.remove();
                for(int i=0;i<4;i++) {
                    int nY = now[0]+dy[i];
                    int nX = now[1]+dx[i];
                    if(nY==itemY*2 && nX==itemX*2) {
                        return dis/2;
                    }
                    
                    if(line[nY][nX]) {
                        line[nY][nX]=false;
                        q.add(new int[]{nY,nX});
                    }
                }
            }
            dis++;
        }
        
        return -1;
    }
}
/*
사각형이 겹쳐져 있음.
꼭짓점에서 만나지 않고, 완전히 포함되지도 않음. 변이 겹치지도 않음.
가운데가 비어있다면 가장 바깥쪽 테두리로 다님
캐릭터와 아이템이 처음부터 같은 경우 X, 모두 테두리 위에 존재함.
---
직사각형 위치 / 캐릭터 위치 / 아이템 위치가 주어졌을 때, 캐릭터가 아이템을 줍기 위한 가장 짧은 거리
---
테두리를 어떻게 그리지?
각 행에서 가장 바깥쪽 열을 갖고있고, 각 열에서는 가장 바깥쪽 행을 알고있으면 되나?
-> 예시 1번처럼 8열에서는 4에서 한번 접고 들어감.
=> 위아래 이동시 현재 행의 가장 끝이 내가 위치한 열이 맞는지 확인.
=> 똑같이 좌우 이동시 현재 열의 가장 끝이 내 행인지 확인. 아니면 이동 방향의 열의 끝 행으로 이동해야함.
지금 온 방향으로는 이동X
=> ㄴ 모양 못 잡음.
---
2차원 배열 두개로 표현.
---
그냥 사각형 안에 다 채우고, 그 채운 곳에 붙어서 이동하게 하면 안되나
채우고 지우지 말고, 다 채우고 다 지우기.
*/