import java.util.*;
import java.io.*;
class Solution {
    int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    int answer = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] room = new int[4][4];
        int[][] dirs = new int[3][17];  //해당 번호 물고기의 방향, 행, 열
        for(int i=0;i<4;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                room[i][j] = num;
                dirs[0][num] = dir;
                dirs[1][num] = i;
                dirs[2][num] = j;
            }
        }

        int fishNum = room[0][0];
        int sharkY = 0;
        int sharkX = 0;
        int sharkDir = dirs[0][fishNum];
        dirs[0][fishNum] = 0;
        room[0][0] = 0;

        dfs(sharkY, sharkX, sharkDir, dirs, room, fishNum);

        System.out.println(answer);
    }

    public void dfs(int sharkY, int sharkX, int sharkDir, int[][] dirs, int[][] room, int sum) {
        answer = Math.max(answer, sum);

        for(int i=1;i<=16;i++) {
            int nowDir = dirs[0][i];
            //먹힌 물고기는 패스
            if (nowDir == 0) {
                continue;
            }
            int nowY = dirs[1][i];
            int nowX = dirs[2][i];

            //최대 8번 탐색
            nowDir--;
            for(int j=0;j<8;j++) {
                nowDir++;
                if(nowDir==9) {
                    nowDir=1;
                }
                int nY = nowY+dy[nowDir];
                int nX = nowX+dx[nowDir];
                if(nY>=0 && nY<4 && nX>=0 && nX<4 && !(nY==sharkY && nX==sharkX)) {
                    dirs[0][i] = nowDir;
                    dirs[1][i] = nY;
                    dirs[2][i] = nX;

                    int pairNum = room[nY][nX];
                    dirs[1][pairNum] = nowY;
                    dirs[2][pairNum] = nowX;

                    int tmp = room[nowY][nowX];
                    room[nowY][nowX] = pairNum;
                    room[nY][nX] = tmp;

                    break;
                }
            }
        }

        for(int i=1;i<=3;i++) {
            int nY = sharkY + dy[sharkDir]*i;
            int nX = sharkX + dx[sharkDir]*i;
            if(nY<0||nY>=4||nX<0||nX>=4 || room[nY][nX]==0) {
                continue;
            }

            int[][] tmpDirs = new int[3][17];
            for(int k=0;k<3;k++) {
                for(int j=0;j<17;j++) {
                    tmpDirs[k][j] = dirs[k][j];
                }
            }

            int[][] tmpRoom = new int[4][4];
            for(int k=0;k<4;k++) {
                for(int j=0;j<4;j++) {
                    tmpRoom[k][j] = room[k][j];
                }
            }

            int fishNum = tmpRoom[nY][nX];
            int nextDir = tmpDirs[0][fishNum];
            tmpDirs[0][fishNum] = 0;
            tmpRoom[nY][nX]=0;

            dfs(nY, nX, nextDir, tmpDirs, tmpRoom, sum + fishNum);
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
물고기 번호는 1~16 \ 방향은 1~8 위쪽부터 반시계방향
1. 상어는 0,0먹고 0,0에 존재. 방향은 0,0물고기와 동일
2. 번호가 작은 물고기부터 이동.
- 물고기는 한 칸 이동 가능 (빈칸과 다른 물고기가 잇는칸으로 이동 가능 \ 상어칸이나 밖으로는 불가)
- 이동할수있을때까지 방향 45도씩 반시계로 회전(영구적임). 한바퀴 돌았는데도 이동못하면 이동안함.
- 다른 물고기가 있는 칸으로 갈 경우 서로 위치 변경
3. 모든 물고기 이동 후 상어가 이동
- 상어는 한 번에 여러 칸 이동 가능. 이 때 0,0에서 0,4로 이동한다면 0,1~3은 먹지 않는다는 말
- 물고기가 있는 칸으로 이동했다면 방향이 그 물고기로 변경.
- 물고기가 없는 칸으로는 이동불가
- 이동할수없으면 종료.
 */