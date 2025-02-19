import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] room = new char[row][col];
        boolean[][] visit = new boolean[row][col];  //0 미방문 1방문 2해제
        for(int i=0;i<row;i++) {
            String s = br.readLine();
            for(int j=0;j<col;j++) {
                room[i][j] = s.charAt(j);
            }
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        int max = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(visit[i][j] || room[i][j]=='W') {
                    continue;
                }
                int time=-1;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                visit[i][j] = true;
                while(!q.isEmpty()) {
                    int size=q.size();
                    while(size-->0) {
                        int[] now = q.remove();
                        int nowY = now[0];
                        int nowX = now[1];
                        for(int k=0;k<4;k++) {
                            int nY=nowY+dy[k];
                            int nX=nowX+dx[k];
                            if (nY < 0 || nY >= row || nX < 0 || nX >= col || room[nY][nX]=='W' || visit[nY][nX]) {
                                continue;
                            }
                            q.add(new int[]{nY,nX});
                            visit[nY][nX] = true;
                        }
                    }
                    time++;
                }
                max = Math.max(max,time);

                for(int k=0;k<row;k++) {
                    Arrays.fill(visit[k],false);
                }
            }
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
bfs진행 후 각 섬마다 마지막에 방문한 노드에서 역으로 bfs를 진행해 거리판별 -> 아래의 경우 10인데 9로 오답.
-> 50*50이니까 매 위치마다 bfs돌리자.
7 7
WLLLLLW
LWLWLWW
LLLWLWW
LWWWLWW
LLLLLWW
LWWWWWW
WWWWWWW

 */