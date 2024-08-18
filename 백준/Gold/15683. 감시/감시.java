import java.util.*;
import java.io.*;

class Solution {

    static int row;
    static int col;
    static int[][] room;
    static int min;
    static int cctvCount;
    static Cctv[] cctvList = new Cctv[8];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        min = row * col;
        room = new int[row][col];

        cctvCount = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                room[i][j] = tmp;
                if (tmp != 0 && tmp != 6) {
                    cctvList[cctvCount] = new Cctv(i, j, tmp, 0);
                    cctvCount++;
                }
            }
        }

        dfs(0, copyRoom(room));
        System.out.println(min);
    }

    public void dfs(int depth, int[][] room) {
        int tmp = 0;
        if (depth == cctvCount) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (room[i][j] == 0) {
                        tmp++;
                    }
                }
            }
            min = Math.min(min, tmp);
            return;
        }

        Cctv cctv = cctvList[depth];
        for (int i = 0; i < cctvHead(cctv.cctvNum); i++) {
            int[][] next = copyRoom(room);
            drawRoom(cctv.row, cctv.col, cctv.cctvNum, i, next);
            dfs(depth + 1, next);
        }
    }

    public int cctvHead(int cctvNum) {
        if (cctvNum == 2) {
            return 2;
        }
        if (cctvNum == 5) {
            return 1;
        }
        return 4;
    }

    //0,1,2,3 상우하좌
    public void drawRoom(int nowY, int nowX, int cctvNum, int direction, int[][] room) {
        switch (cctvNum) {
            case 1:
                if (direction == 0) {
                    drawNorth(nowY, nowX, room);
                    return;
                }
                if (direction == 1) {
                    drawEast(nowY, nowX, room);
                    return;
                }
                if (direction == 2) {
                    drawSouth(nowY, nowX, room);
                    return;
                }
                drawWest(nowY, nowX, room);
                return;
            case 2:
                if (direction == 0) {
                    drawWest(nowY, nowX, room);
                    drawEast(nowY, nowX, room);
                    return;
                } else {
                    drawNorth(nowY, nowX, room);
                    drawSouth(nowY, nowX, room);
                }
                break;
            case 3:
                if (direction == 0) {
                    drawNorth(nowY, nowX, room);
                    drawEast(nowY, nowX, room);
                    return;
                }
                if (direction == 1) {
                    drawSouth(nowY, nowX, room);
                    drawEast(nowY, nowX, room);
                    return;
                }
                if (direction == 2) {
                    drawSouth(nowY, nowX, room);
                    drawWest(nowY, nowX, room);
                    return;
                }
                drawNorth(nowY, nowX, room);
                drawWest(nowY, nowX, room);
                return;
            case 4:
                if (direction == 0) {
                    drawNorth(nowY, nowX, room);
                    drawEast(nowY, nowX, room);
                    drawWest(nowY, nowX, room);
                    return;
                }
                if (direction == 1) {
                    drawNorth(nowY, nowX, room);
                    drawSouth(nowY, nowX, room);
                    drawEast(nowY, nowX, room);
                    return;
                }
                if (direction == 2) {
                    drawSouth(nowY, nowX, room);
                    drawEast(nowY, nowX, room);
                    drawWest(nowY, nowX, room);
                    return;
                }
                drawNorth(nowY, nowX, room);
                drawSouth(nowY, nowX, room);
                drawWest(nowY, nowX, room);
                return;
            case 5:
                drawNorth(nowY, nowX, room);
                drawSouth(nowY, nowX, room);
                drawEast(nowY, nowX, room);
                drawWest(nowY, nowX, room);
                break;
        }
    }

    public void drawNorth(int nowY, int nowX, int[][] room) {
        for (int i = nowY - 1; i >= 0; i--) {
            if (room[i][nowX] == 6) {
                return;
            }
            room[i][nowX] = -1;
        }
    }

    public void drawSouth(int nowY, int nowX, int[][] room) {
        for (int i = nowY + 1; i < row; i++) {
            if (room[i][nowX] == 6) {
                return;
            }
            room[i][nowX] = -1;
        }
    }

    public void drawEast(int nowY, int nowX, int[][] room) {
        for (int i = nowX + 1; i < col; i++) {
            if (room[nowY][i] == 6) {
                return;
            }
            room[nowY][i] = -1;
        }
    }

    public void drawWest(int nowY, int nowX, int[][] room) {
        for (int i = nowX - 1; i >= 0; i--) {
            if (room[nowY][i] == 6) {
                return;
            }
            room[nowY][i] = -1;
        }
    }

    public int[][] copyRoom(int[][] room) {
        int[][] tmp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmp[i][j] = room[i][j];
            }
        }
        return tmp;
    }
}
class Cctv {
    int row;
    int col;
    int cctvNum;
    int direct;

    Cctv(int row, int col, int cctvNum, int direct) {
        this.row = row;
        this.col = col;
        this.cctvNum = cctvNum;
        this.direct = direct;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
입력
첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)
둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다.
0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타낸다.
CCTV의 최대 개수는 8개를 넘지 않는다.

과정
1번 CCTV는 한 쪽 방향만 감시할 수 있다.
2번과 3번은 두 방향을 감시할 수 있는데, 2번은 감시하는 방향이 서로 반대방향이어야 하고, 3번은 직각 방향이어야 한다.
4번은 세 방향, 5번은 네 방향을 감시할 수 있다.
CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시할 수 있다.
사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다. CCTV가 감시할 수 없는 영역은 사각지대라고 한다.
CCTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
CCTV는 CCTV를 통과할 수 있다.


출력
첫째 줄에 사각 지대의 최소 크기를 출력한다.

해결
재귀를 사용하여 각 cctv별 모든 가능한 경우 탐색
 */