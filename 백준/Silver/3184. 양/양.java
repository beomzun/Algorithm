import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] ground = new char[R][C];
        int vCount = 0;
        int oCount = 0;
        for(int i=0;i<R;i++) {
            String s = br.readLine();
            for(int j=0;j<C;j++) {
                ground[i][j] = s.charAt(j);
                if(ground[i][j]=='o') {
                    oCount++;
                } else if(ground[i][j]=='v') {
                    vCount++;
                }
            }
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        boolean[][] visit = new boolean[R][C];
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(visit[i][j] || ground[i][j]=='#' || ground[i][j]=='.') {
                    continue;
                }
                visit[i][j] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                int nowV = 0;
                int nowO = 0;
                while(!q.isEmpty()) {
                    int[] now = q.remove();
                    int nowY = now[0];
                    int nowX = now[1];
                    if(ground[nowY][nowX]=='o') {
                        nowO++;
                    } else if(ground[nowY][nowX]=='v') {
                        nowV++;
                    }
                    for(int k = 0;k<4;k++) {
                        int nY = nowY+dy[k];
                        int nX = nowX+dx[k];
                        if(nY<0||nY>=R||nX<0||nX>=C || visit[nY][nX]||ground[nY][nX]=='#') {
                            continue;
                        }
                        visit[nY][nX]=true;
                        q.add(new int[]{nY,nX});
                    }
                }
                if(nowV>=nowO) {
                    oCount-=nowO;
                } else {
                    vCount-=nowV;
                }
            }
        }

        System.out.println(oCount+" "+vCount);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

