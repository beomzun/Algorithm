import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] ground = new char[R][C];
        int[][] times = new int[R][C];
        int init = 2500;
        for(int i=0;i<R;i++) {
            Arrays.fill(times[i], init);
        }
        int nowY=0;
        int nowX=0;
        Queue<int[]> waterQ = new ArrayDeque<>();
        for(int i=0;i<R;i++) {
            String s = br.readLine();
            for(int j=0;j<C;j++) {
                char c = s.charAt(j);
                ground[i][j] = c;
                if(c=='S') {
                    nowY = i;
                    nowX = j;
                } else if(c=='*') {
                    waterQ.add(new int[]{i, j});
                    times[i][j] = 0;
                }
            }
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};

        int time = 1;
        while(!waterQ.isEmpty()) {
            int size = waterQ.size();
            while(size-->0) {
                int[] now = waterQ.remove();
                int y = now[0];
                int x = now[1];
                for(int i=0;i<4;i++) {
                    int nY = y+dy[i];
                    int nX = x+dx[i];
                    if (nY < 0 || nY >= R || nX < 0 || nX >= C || ground[nY][nX]=='X' || ground[nY][nX]=='D' || times[nY][nX]!=init) {
                        continue;
                    }
                    waterQ.add(new int[]{nY,nX});
                    times[nY][nX] = time;
                }
            }
            time++;
        }

        boolean[][] visit = new boolean[R][C];
        visit[nowY][nowX] = true;
        int dTime = 1;
        Queue<int[]> dQ = new ArrayDeque<>();
        dQ.add(new int[]{nowY, nowX});
        while(!dQ.isEmpty()) {
            int size = dQ.size();
            while(size-->0) {
                int[] now = dQ.remove();
                int y = now[0];
                int x = now[1];
                for(int i=0;i<4;i++) {
                    int nY = y+dy[i];
                    int nX = x+dx[i];
                    if (nY < 0 || nY >= R || nX < 0 || nX >= C || ground[nY][nX]=='X' || visit[nY][nX]) {
                        continue;
                    }
                    if(ground[nY][nX]=='D') {
                        System.out.println(dTime);
                        return;
                    }
                    if (times[nY][nX] <= dTime) {
                        continue;
                    }

                    visit[nY][nX] = true;
                    dQ.add(new int[]{nY,nX});
                }
            }
            dTime++;
        }

        System.out.println("KAKTUS");
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
빈 곳 . \ 물은 * \ 돌은 x \ 비버는 D \ 고슴도치는 S
물 -> 고슴도치
최소 탈출 시간 / KAKTUS
 */