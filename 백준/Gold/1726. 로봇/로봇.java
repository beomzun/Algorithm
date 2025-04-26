import java.util.*;
import java.io.*;
class Solution {
    int endY;
    int endX;
    int endDir;
    int[] dy = {0,0,0,1,-1};
    int[] dx = {0,1,-1,0,0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] factory = new boolean[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                factory[i][j] = Integer.parseInt(st.nextToken())==0;
            }
        }
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startDir = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endDir = Integer.parseInt(st.nextToken());
        if(isArrive(startY, startX, startDir)) {
            System.out.println(0);
            return;
        }

        boolean[][][] visit = new boolean[N+1][M+1][5];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startY, startX, startDir});
        visit[startY][startX][startDir]=true;
        int time = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int[] now = q.remove();
                int nowY = now[0];
                int nowX = now[1];
                int nowDir = now[2];
                //좌회전
                int leftDir = turnLeft(nowDir);
                if(!visit[nowY][nowX][leftDir]) {
                    if(isArrive(nowY, nowX, leftDir)) {
                        System.out.println(time);
                        return;
                    }
                    q.add(new int[]{nowY, nowX, leftDir});
                    visit[nowY][nowX][leftDir] = true;
                }

                //우회전
                int rightDir = turnRight(nowDir);
                if(!visit[nowY][nowX][rightDir]) {
                    if(isArrive(nowY, nowX, rightDir)) {
                        System.out.println(time);
                        return;
                    }
                    q.add(new int[]{nowY, nowX, rightDir});
                    visit[nowY][nowX][rightDir] = true;
                }

                //직진
                int nY = nowY;
                int nX = nowX;
                for(int i=1;i<=3;i++) {
                    nY += dy[nowDir];
                    nX += dx[nowDir];
                    if(nY<=0||nY>N||nX<=0||nX>M || !factory[nY][nX]) {
                        break;
                    }
                    if(visit[nY][nX][nowDir]) {
                        continue;
                    }

                    if(isArrive(nY, nX, nowDir)) {
                        System.out.println(time);
                        return;
                    }
                    q.add(new int[]{nY, nX, nowDir});
                    visit[nY][nX][nowDir] = true;
                }
            }
            time++;
        }
    }
    public boolean isArrive(int nowY, int nowX, int nowDir) {
        if(nowY==endY && nowX==endX && nowDir==endDir) {
            return true;
        }
        return false;
    }
    public int turnLeft(int nowDir) {
        switch(nowDir) {
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            default:
                return 2;
        }
    }
    public int turnRight(int nowDir) {
        switch(nowDir) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 2;
            default:
                return 1;
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
Go k : 최대 3칸까지 현재 방향으로 전진.
Turn dir : 좌,우로 회전.
동서남북 1234 \ +1이면 %4 +1 \ -1이면
1좌=4 1우=3 \ 2좌=3 2우=4 \ 3좌=1 3우=2 \ 4좌=2 4우=1
현재 좌표에서 도착 좌표까지 최소 명령어.
 */