import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        int[][] roomNums = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dy = {0,-1,0,1};
        int[] dx = {-1,0,1,0};
        boolean[][] visit = new boolean[N][M];
        ArrayList<Integer> roomSize = new ArrayList<>();
        int roomNum = 0;
        int maxSize = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(visit[i][j]) {
                    continue;
                }
                visit[i][j] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                int size=1;
                while(!q.isEmpty()) {
                    int[] now = q.remove();
                    int nowY=now[0];
                    int nowX=now[1];
                    for(int k=0;k<4;k++) {
                        int bit = (int)Math.pow(2,k);
                        int nY = nowY+dy[k];
                        int nX = nowX+dx[k];
                        if(nY<0||nY>=N||nX<0||nX>=M) {
                            continue;
                        }

                        if((room[nowY][nowX] & bit)==0 && !visit[nY][nX]) {
                            visit[nY][nX]=true;
                            q.add(new int[]{nY,nX});
                            size++;
                        }
                    }
                    roomNums[nowY][nowX] = roomNum;
                }
                roomSize.add(size);
                maxSize = Math.max(maxSize, size);
                roomNum++;
            }
        }

        int maxSum = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                int nowNum = roomNums[i][j];
                for(int k=0;k<4;k++) {
                    int nY = i+dy[k];
                    int nX = j+dx[k];
                    if(nY<0||nY>=N||nX<0||nX>=M) {
                        continue;
                    }
                    int neighNum = roomNums[nY][nX];
                    if(nowNum!=neighNum) {
                        int sum = roomSize.get(nowNum) + roomSize.get(neighNum);
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }

        System.out.println(roomNum+"\n"+maxSize+"\n"+maxSum);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
방 개수 / 가장 넓은 방 크기 -> bfs 한번
제거하여 얻을수있는 방 크기 -> 상하좌우
N,M 스왑

서-1 북-2 동-4 남-8
비트마스킹 -> 0이고 방문기록 없으면 해당 방향 방문
 */
