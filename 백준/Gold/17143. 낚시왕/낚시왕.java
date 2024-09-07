import java.util.*;
import java.io.*;
class Solution {
    static int result = 0;
    static int R;
    static int C;
    static int M;
    static int killedY;
    static int killedX;
    static int[][] sea;
    static Queue<Shark> sharks = new ArrayDeque<>();

    public void solution() throws IOException {
        input();
        move(0);
        System.out.println(result);
    }

    public void move(int depth) {
        if (depth == C) {
            return;
        }
        //상어 잡기
        sharkCatch(depth);
        //상어 이동
        sharkMove();
        move(depth + 1);
    }

    public void sharkCatch(int depth) {
        for (int i = 0; i < R; i++) {
            if (sea[i][depth] > 0) {
                killedY = i;
                killedX = depth;
                result += sea[i][depth];
                return;
            }
        }
        killedY = -1;
    }

    public void sharkMove() {
        //큐에서 빼서 잡힌놈인지 확인. 안잡혔으면 큐에 다시넣고 바다에 표시
        //바다 리셋 필요
        int size = sharks.size();
        Shark[][] tmp = new Shark[R][C];
        for (int i = 0; i < size; i++) {
            Shark shark = sharks.remove();
            if (shark.y == killedY && shark.x == killedX) {
                continue;
            }
            swim(shark);

            Shark past = tmp[shark.y][shark.x];
            if (past == null || past.size < shark.size) {
                tmp[shark.y][shark.x] = shark;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sea[i][j] = 0;
                if (tmp[i][j] != null) {
                    sharks.add(tmp[i][j]);
                    sea[i][j] = tmp[i][j].size;
                }
            }
        }
    }
    public void swim(Shark shark) {
        int tmpSpeed = shark.speed;
        while (tmpSpeed != 0) {
            if (shark.dir == 1) {
                if (tmpSpeed > shark.y) {
                    tmpSpeed -= shark.y;
                    shark.y = 0;
                    shark.dir = 2;
                } else {
                    shark.y -= tmpSpeed;
                    tmpSpeed = 0;
                }
            } else if (shark.dir == 2) {
                if (tmpSpeed > R - 1 - shark.y) {
                    tmpSpeed -= R - 1 - shark.y;
                    shark.y = R - 1;
                    shark.dir = 1;
                } else {
                    shark.y += tmpSpeed;
                    tmpSpeed = 0;
                }
            } else if (shark.dir == 3) {
                if (tmpSpeed > C - 1 - shark.x) {
                    tmpSpeed -= C - 1 - shark.x;
                    shark.x = C - 1;
                    shark.dir = 4;
                } else {
                    shark.x += tmpSpeed;
                    tmpSpeed = 0;
                }
            } else {
                if (tmpSpeed > shark.x) {
                    tmpSpeed -= shark.x;
                    shark.x = 0;
                    shark.dir = 3;
                } else {
                    shark.x -= tmpSpeed;
                    tmpSpeed = 0;
                }
            }
        }
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sea = new int[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sea[r][c] = z;
            sharks.add(new Shark(r, c, s, d, z));
        }
    }
}
class Shark {
    int y;
    int x;
    int speed;
    int dir;
    int size;

    Shark(int y, int x, int speed, int dir, int size) {
        this.y = y;
        this.x = x;
        this.speed = speed;
        this.dir = dir;
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
낚시왕 한칸 이동 -> 해당 열 y 가장 작은 상어 삭제 -> 상어들 이동(이동 후 같은 칸에는 제일 큰 애만 남음)
약육강식 표현 위해 모든 상어 이동시까지 임시상어배열 사용
 */