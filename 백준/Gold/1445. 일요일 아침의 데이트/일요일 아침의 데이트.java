import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] room = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                room[i][j] = s.charAt(j);
            }
        }
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        int sY = -1;
        int sX = -1;
        int eY = -1;
        int eX = -1;
        //row col 0-직 1-간
        boolean[][][] dirty = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = room[i][j];
                if (c == '.') {
                    continue;
                }
                //쓰레기 주변 구역 간접처리
                if (c == 'g') {
                    dirty[i][j][0] = true;
                    for (int k = 0; k < 4; k++) {
                        int nY = i + dy[k];
                        int nX = j + dx[k];
                        if (nY >= 0 && nY < N && nX >= 0 && nX < M &&
                                room[nY][nX]!='g' && room[nY][nX]!='S' && room[nY][nX]!='F') {
                            dirty[nY][nX][1] = true;
                        }
                    }
                    continue;
                }
                if (c == 'S') {
                    sY = i;
                    sX = j;
                    continue;
                }
                if (c == 'F') {
                    eY = i;
                    eX = j;
                }
            }
        }

        int[][][] dirtyCounts = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dirtyCounts[i][j], 2500);
            }
        }
        dirtyCounts[sY][sX][0] = dirty[sY][sX][0] ? 1 : 0;
        dirtyCounts[sY][sX][1] = dirty[sY][sX][1] ? 1 : 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sY, sX});
        while (!q.isEmpty()) {
            int[] now = q.remove();
            int nowY = now[0];
            int nowX = now[1];
            for (int i = 0; i < 4; i++) {
                int nY = nowY+dy[i];
                int nX = nowX+dx[i];
                if(nY<0||nY>=N||nX<0||nX>=M) {
                    continue;
                }

                int direct = dirty[nY][nX][0] ? 1 : 0;
                int indirect = dirty[nY][nX][1] ? 1 : 0;
                if(dirtyCounts[nowY][nowX][0] + direct < dirtyCounts[nY][nX][0]) {
                    dirtyCounts[nY][nX][0] = dirtyCounts[nowY][nowX][0] + direct;
                    dirtyCounts[nY][nX][1] = dirtyCounts[nowY][nowX][1] + indirect;
                    q.add(new int[]{nY,nX});
                } else if(dirtyCounts[nowY][nowX][0] + direct == dirtyCounts[nY][nX][0]) {
                    if(dirtyCounts[nowY][nowX][1] + indirect < dirtyCounts[nY][nX][1]) {
                        dirtyCounts[nY][nX][1] = dirtyCounts[nowY][nowX][1] + indirect;
                        q.add(new int[]{nY,nX});
                    }
                }
            }
        }

        System.out.println(dirtyCounts[eY][eX][0] + " " + dirtyCounts[eY][eX][1]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1. 쓰레기로 차있는 칸을 적게
2. 쓰레기 옆을 지나가는 칸을 적게
를 만족하는 S에서 F까지의 최단거리
---
bfs를 하는데, 과거의 움직임보다 현재의 움직임이 여친이 더 좋아할때 갱신
청정구역, 쓰레기옆구역, 쓰레기구역 으로 나누기.
---
쓰레기가 있는칸은 쓰레기 옆칸과 동시에 취급해서는 안됨.
시작과 종료칸은 세지 않는다.
 */