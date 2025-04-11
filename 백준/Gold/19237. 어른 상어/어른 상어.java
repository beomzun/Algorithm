import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][][] room = new int[N][N][2];  //i행 j열의 0층은 주인 1층은 남은시간
        int[][] dir = new int[M+1][3];   // 1,2,3,4 상 하 좌 우, 죽으면 -1 \ 0행 방향, 1행 y, 2행 x
        int[][] priority = new int[M * 4 + 1][5];
        int[] priorityY = {0,-1,1,0,0};
        int[] priorityX = {0,0,0,-1,1};

        //방 시작 정보
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num>0) {
                    dir[num][1] = i;
                    dir[num][2] = j;
                    room[i][j][1] = K;
                }
                room[i][j][0] = num;
            }
        }

        //시작 방향 정보
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++) {
            dir[i][0] = Integer.parseInt(st.nextToken());
        }

        //우선순위 정보, i번 상어가 j방향일 때, 1번 상어가 1방향이면 1, 3번 상어가 3방향이면 11
        for(int i=0;i<M;i++) {
            for(int j=1;j<=4;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<4;k++) {
                    priority[i * 4 + j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int time = 1;
        int removeCount = 0;
        while(time<=1000) {
            // 이동하고 줄이고 뿌리고
            //dir을 움직이고 -> 순서대로 room에 배치.
            for(int i=1;i<=M;i++) {
                int nowDir = dir[i][0];
                if(nowDir==-1) {
                    continue;
                }
                int nowY = dir[i][1];
                int nowX = dir[i][2];

                boolean find = false;
                //우선순위1 무취
                for(int j=0;j<4;j++) {
                    int priorityDir = priority[(i-1)*4+nowDir][j];
                    int nY = nowY + priorityY[priorityDir];
                    int nX = nowX + priorityX[priorityDir];
                    if(nY<0||nY>=N||nX<0||nX>=N) {
                        continue;
                    }
                    if(room[nY][nX][1]==0) {
                        dir[i][0] = priorityDir;
                        dir[i][1] = nY;
                        dir[i][2] = nX;
                        find = true;
                        break;
                    }
                }

                //우선순위2 내취
                if(!find) {
                    for(int j=0;j<4;j++) {
                        int priorityDir = priority[(i-1)*4+nowDir][j];
                        int nY = nowY + priorityY[priorityDir];
                        int nX = nowX + priorityX[priorityDir];
                        if(nY<0||nY>=N||nX<0||nX>=N) {
                            continue;
                        }
                        if(room[nY][nX][1]>0 && room[nY][nX][0]==i) {
                            dir[i][0] = priorityDir;
                            dir[i][1] = nY;
                            dir[i][2] = nX;
                            break;
                        }
                    }
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(room[i][j][1]>0) {
                        room[i][j][1]--;
                    }
                }
            }

            for(int i=1;i<=M;i++) {
                if(dir[i][0]==-1) {
                    continue;
                }
                //새 위치에 큰 번호가 방금 왔다면 제거
                int nowY = dir[i][1];
                int nowX = dir[i][2];
                if(room[nowY][nowX][1]==K) {
                    dir[i][0] = -1;
                    removeCount++;
                    continue;
                }
                room[nowY][nowX][0] = i;
                room[nowY][nowX][1] = K;
            }

            if(removeCount==M-1) {
                System.out.println(time);
                return;
            }

            time++;
        }
        System.out.println(-1);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N*N 격자
상어에 M까지의 번호 배정.
매초마다 상어는 자신의 위치에 냄새를 뿌린다.
1초마다 모든 상어가 동시에 상하좌우 중 하나로 이동하고, 자신의 냄새를 남긴다. 냄새는 k초 이후 사라짐.
이동방향 결정
- 아무 냄새가 없는 칸
- 없으면 내 냄새가 있는 칸
이 때 가능한 칸이 여러 개인 경우, 특정한 우선순위를 따른다. 상어마다 우선순위 다름
방향은 이동방향으로.

모든 상어가 이동 완료 후 한 칸에 여러 마리의 상어가 있다면, 가장 작은 번호의 상어만 남는다.
 */