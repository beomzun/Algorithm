import java.util.*;
import java.io.*;
class Solution {
    static int R;
    static int C;
    static int T;
    static int[][] room;
    static int AIR;     //공기청정기 위치
    static Queue<Dust> dusts = new ArrayDeque<>();
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public void solution() throws IOException {
        input();
        for (int i = 0; i < T; i++) {
            spread();
            cleanAir();
            findDust();
        }
        System.out.println(dustSize());
    }
    public int dustSize() {
        int result = 0;
        while (!dusts.isEmpty()) {
            result += dusts.remove().size;
        }
        return result;
    }

    public void findDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    dusts.add(new Dust(i, j, room[i][j]));
                }
            }
        }
    }
    public void cleanAir() {
        //위
        for (int i = AIR - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            room[0][i] = room[0][i + 1];
        }
        for (int i = 0; i < AIR; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            room[AIR][i] = room[AIR][i - 1];
        }
        room[AIR][1] = 0;
        //아래
        for (int i = AIR + 2; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            room[R - 1][i] = room[R - 1][i + 1];
        }
        for (int i = R - 1; i > AIR + 1; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            room[AIR + 1][i] = room[AIR + 1][i - 1];
        }
        room[AIR + 1][1] = 0;
    }

    public void spread() {
        int[][] tmp = new int[R][C];
        while(!dusts.isEmpty()) {
            Dust dust = dusts.remove();
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int nY = dust.y + dy[j];
                int nX = dust.x + dx[j];
                if (isOut(nY, nX) || isAir(nY, nX)) {
                    continue;
                }
                count++;
                tmp[nY][nX] += dust.size / 5;
            }
            tmp[dust.y][dust.x] += dust.size - (count * (dust.size / 5));
        }
        reflect(tmp);
    }

    public void reflect(int[][] tmp) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int size = tmp[i][j];
                room[i][j] = size;
            }
        }
    }

    public boolean isOut(int y, int x) {
        return y < 0 || y >= R || x < 0 || x >= C;
    }

    public boolean isAir(int y, int x) {
        return x == 0 && (y == AIR || y == AIR + 1);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        room = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int val = Integer.parseInt(st.nextToken());
                room[i][j] = val;
                if (val == -1) {
                    AIR = i - 1;
                }
                if (val > 0) {
                    dusts.add(new Dust(i, j, val));
                }
            }
        }
    }
}
class Dust {
    int y;
    int x;
    int size;

    Dust(int y, int x, int size) {
        this.y = y;
        this.x = x;
        this.size = size;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
확산은 동시에. 미세먼지큐 활용. 기존거, 계속 업데이트 되는거. 어떻게 반영?
-> 큐에서 빼면서 해당 위치 미세먼지양 조절 및 주변으로 분산. 내 위치 미세먼지가 영향 받았다면? 이를 위해 매 확산마다 임시 배열 사용.
 */