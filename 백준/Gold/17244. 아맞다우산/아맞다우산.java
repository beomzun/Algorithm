import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        char[][] room = new char[row][col];

        int sY = -1;
        int sX = -1;
        int itemCount = 0;
        for(int i=0;i<row;i++) {
            String s = br.readLine();
            for(int j=0;j<col;j++) {
                room[i][j] = s.charAt(j);
                if(room[i][j]=='X') {
                    room[i][j] = (char)(itemCount++ +'0');
                } else if(room[i][j]=='S') {
                    sY = i;
                    sX = j;
                    room[i][j] = '.';
                }
            }
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        //행 열 시간 발견
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visit = new boolean[row][col][1 << itemCount];
        q.add(new int[]{sY,sX,0,0});
        visit[sY][sX][0] = true;
        while(!q.isEmpty()) {
            int[] now = q.remove();
            for(int i=0;i<4;i++) {
                int nY = now[0]+dy[i];
                int nX = now[1]+dx[i];

                if(room[nY][nX]=='#' || visit[nY][nX][now[3]]) {
                    continue;
                }

                if(room[nY][nX]=='.') {
                    visit[nY][nX][now[3]] = true;
                    q.add(new int[]{nY, nX, now[2] + 1, now[3]});
                } else if(room[nY][nX]=='E') {
                    if(Integer.bitCount(now[3])==itemCount) {
                        System.out.println(now[2] + 1);
                        return;
                    }
                } else {
                    visit[nY][nX][now[3] | 1<<(room[nY][nX]-'0')] = true;
                    q.add(new int[]{nY, nX, now[2] + 1, now[3] | 1 << (room[nY][nX] - '0')});
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
S에서 출발해서 E까지 도착해야함.
중간에 모든 X를 거쳐가는 최소이동거리.
---
전혀 생각하지 못함.
2의 아이템 개수 승만큼의 h를 갖는 visit 배열관리.
=> 발견한 아이템에 따라 bfs 돌리기.
큐에 방문한 위치, 방문시간, 아이템발견현황 삽입
 */