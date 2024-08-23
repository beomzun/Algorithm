import java.util.*;
import java.io.*;

class Solution {
    static int[][][] cube = new int[5][5][5];   //첫 입력
    static int[] rotate = {0, 0, 0, 0, 0};   //판별 회전수 0-3
    static boolean[][][] visit = new boolean[5][5][5];  //현재 시점에서 큐브의 방문여부
    static int[] floor = {-1, -1, -1, -1, -1};    //해당 층이 몇번째 판인지
    static boolean[] used = {false, false, false, false, false};    //해당 판이 배치되었는지
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 0, 0, 1, 0, 0};
    static int[] dx = {0, -1, 1, 0, 0, 0};
    static int min = Integer.MAX_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {   //판
            for (int j = 0; j < 5; j++) {   //행
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {   //열
                    cube[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        select(0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    //판 순서
    public void select(int count) {
        if (count == 5) {
            spin(0);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!used[i]) {
                used[i] = true;
                floor[count] = i;
                select(count + 1);
                used[i] = false;
            }
        }
    }

    //판 회전
    public void spin(int count) {
        if (count == 5) {
            int[] start = position(0, 0, 0);
            int[] end = position(4, 4, 4);

            if (cube[floor[0]][start[0]][start[1]] == 1 && cube[floor[4]][end[0]][end[1]] == 1) {
                visit = new boolean[5][5][5];
                queue.clear();

                queue.add(new int[]{0, 0, 0});
                visit[0][start[0]][start[1]] = true;
                bfs();
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            rotate[floor[count]] = i;
            spin(count + 1);
        }
    }

    //탐색
    public void bfs() {
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.remove();
                if (tmp[0] == 4 && tmp[1] == 4 && tmp[2] == 4) {
                    min = Math.min(min, time);
                    if (min == 12) {
                        System.out.println(12);
                        System.exit(0);
                    }
                    return;
                }

                for (int j = 0; j < 6; j++) {
                    int nextZ = tmp[0] + dz[j];
                    int nextY = tmp[1] + dy[j];
                    int nextX = tmp[2] + dx[j];

                    if (nextZ < 0 || nextZ >= 5 || nextY < 0 || nextY >= 5 || nextX < 0 || nextX >= 5) {
                        continue;
                    }
                    int[] next = position(nextZ, nextY, nextX);
                    if (!visit[nextZ][next[0]][next[1]] && cube[floor[nextZ]][next[0]][next[1]] == 1) {
                        queue.add(new int[]{nextZ, nextY, nextX});
                        visit[nextZ][next[0]][next[1]] = true;
                    }
                }
            }
            time++;
        }
    }

    //해당 층에서 회전에 따른 위치 변환
    public int[] position(int z, int y, int x) {
        return switch (rotate[floor[z]]) {
            default -> new int[]{y, x};
            case 1 -> new int[]{x, 4 - y};
            case 2 -> new int[]{4 - y, 4 - x};
            case 3 -> new int[]{4 - x, y};
        };
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
해결
판 회전 * 4 \ 판 위치 * 5!  \ 총 개수 125 => 1024 * 120 * 125
select 로 판 순서 결정 -> 모든 판 순서 결정했으면 spin으로 각 판별 회전 결정 -> 모든 판 회전도 결정했으면 탐색 시작

 */