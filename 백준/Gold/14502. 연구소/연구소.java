import java.util.*;
import java.io.*;

class Solution {
    static int max = 0;
    static int N;
    static int M;
    static int[][] room;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public void solution() throws IOException {
        input();

        makeWall(0, 0);

        System.out.println(max);
    }

    public void makeWall(int idx, int count) {
        if (count == 3) {
            int[][] tmp = copyRoom();
            for (int[] virus : viruses) {
                spread(virus, tmp);
            }
            safe(tmp);
            return;
        }


        for (int i = idx; i < N * M; i++) {
            if (room[i / M][i % M] == 0) {
                room[i / M][i % M] = 1;
                makeWall(i + 1, count + 1);
                room[i / M][i % M] = 0;
            }
        }
    }

    //바이러스 퍼지기
    public void spread(int[] virus, int[][] now) {
        int y = virus[0];
        int x = virus[1];

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                continue;
            }
            if (now[nextY][nextX] == 0) {
                now[nextY][nextX] = 2;
                spread(new int[]{nextY, nextX}, now);
            }
        }
    }

    public void safe(int[][] tmp) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }

    public int[][] copyRoom() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = room[i][j];
            }
        }
        return tmp;
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                room[i][j] = val;
                if (val == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
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
0은 빈 칸, 1은 벽, 2는 바이러스
벽 세우고 -> 퍼트리고 -> 안전영역 확인 \\ 매 경우마다 원본 복사
 */