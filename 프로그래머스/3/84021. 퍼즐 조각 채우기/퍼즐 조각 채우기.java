import java.util.*;
class Solution {
    int[] dy = new int[]{-1,0,1,0};
    int[] dx = new int[]{0,-1,0,1};
    
    // 퍼즐 크기별 좌표리스트
    Map<Integer, ArrayList<ArrayList<int[]>>> map = new HashMap<>();
    
    public int solution(int[][] game_board, int[][] table) {
        int row = game_board.length;
        int col = game_board[0].length;
        
        int answer = 0;
        
        // 테이블 탐색
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(table[i][j]==0) {
                    continue;
                }
                
                Queue<int[]> q = new ArrayDeque<>();
                ArrayList<int[]> list = new ArrayList<>();
                q.add(new int[]{i,j});
                table[i][j] = 0;
                while(!q.isEmpty()) {
                    int[] now = q.remove();
                    list.add(now);
                    for(int k=0;k<4;k++) {
                        int nY = now[0]+dy[k];
                        int nX = now[1]+dx[k];
                        if(nY<0||nY>=row||nX<0||nX>=col||table[nY][nX]==0) {
                            continue;
                        }
                        table[nY][nX]=0;
                        q.add(new int[]{nY,nX});
                    }
                }
                if(!map.containsKey(list.size())) {
                    map.put(list.size(), new ArrayList<>());
                }
                map.get(list.size()).add(list);
            }
        }
        
        // 보드 탐색
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(game_board[i][j]==1) {
                    continue;
                }
                
                Queue<int[]> q = new ArrayDeque<>();
                ArrayList<int[]> list = new ArrayList<>();
                q.add(new int[]{i,j});
                game_board[i][j]=1;
                while(!q.isEmpty()) {
                    int[] now = q.remove();
                    list.add(now);
                    for(int k=0;k<4;k++) {
                        int nY = now[0]+dy[k];
                        int nX = now[1]+dx[k];
                        if(nY<0||nY>=row||nX<0||nX>=col||game_board[nY][nX]==1) {
                            continue;
                        }
                        game_board[nY][nX]=1;
                        q.add(new int[]{nY,nX});
                    }
                }
                
                // 해당 크기의 퍼즐이 없는 경우
                if(!map.containsKey(list.size())) {
                    continue;
                }
                
                //있다면, 
                // 보드 정규화
                int minY = 50;
                int minX = 50;
                for(int[] p : list) {
                    minY = Math.min(minY, p[0]);
                    minX = Math.min(minX, p[1]);
                }
                for(int[] p : list) {
                    p[0]-=minY;
                    p[1]-=minX;
                }
                list.sort((o1,o2)-> {
                    if(o1[0]==o2[0]) {
                        return o1[1]-o2[1];
                    }
                    return o1[0]-o2[0];
                });
                
                if(findPuzzle(list)) {
                    answer += list.size();
                }
            }
        }
        
        return answer;
    }
    
    // 테이블 정규화
    public boolean findPuzzle(ArrayList<int[]> list) {
                for(ArrayList<int[]> tList: map.get(list.size())) {
                    // 회전하면서 검증
                    for(int i=0;i<4;i++) {
                        //회전
                        for(int[] p: tList) {
                            int tmp = p[0];
                            p[0] = p[1];
                            p[1] = -tmp;
                        }
                        
                        //정규화-정렬
                        int minY = 50;
                        int minX = 50;
                        for(int[] p : tList) {
                            minY = Math.min(minY, p[0]);
                            minX = Math.min(minX, p[1]);
                        }
                        for(int[] p : tList) {
                            p[0]-=minY;
                            p[1]-=minX;
                        }
                        
                        tList.sort((o1,o2)-> {
                            if(o1[0]==o2[0]) {
                                return o1[1]-o2[1];
                            }
                            return o1[0]-o2[0];
                        });
                        
                        //검증
                        boolean same = true;
                        for(int k=0;k<tList.size();k++) {
                            if(!Arrays.equals(tList.get(k), list.get(k))) {
                                same=false;
                                break;
                            }
                        }
                        if(same) {
                            map.get(list.size()).remove(tList);
                            return true;
                        }
                    }
                }
        
        return false;
    }
}
/*
퍼즐을 빈 공간에 배치하기
규칙
- 한번에 하나씩
- 회전 가능
- 뒤집기 불가
- 배치한 후에 인접한 칸에 빈칸이 있어서는 안됨
최대 몇 칸을 채울수있는가
---
행,열 <=50
0은 빈칸, 1은 채워진칸
연속된 빈칸은 최대 6칸
---
게임보드에서 빈공간 만날때, 테이블에서 공간크기의 퍼즐들 매핑해보기.
매핑을 어떻게 해야되지?
1. 테이블에서 퍼즐만나면 크기별로 bfs돌면서 상대위치 저장(어차피 탐색은 상좌하우 순임)
2. 보드에서 빈공간 탐색 -> 상대위치랑 크기 동시 확인 후 저장한 테이블퍼즐 돌리면서 상대위치 확인
*/