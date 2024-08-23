import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[][] board;
    static Queue<Apple> apples = new LinkedList<>();
    static Queue<int[]> moved = new LinkedList<>();
    static int[] head = {0, 0};
    static int[] tail = {0, 0};
    static int[] dir = {0, 1};
    static int time = 1;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y-1][x-1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            apples.add(new Apple(time, dir));
        }

        board[0][0] = -1;
        crawl(0, 0);
        System.out.println(time);
    }

    public void crawl(int y, int x) {
        //다음이 벽인 경우
        if (!canGo(y, x)) {
            return;
        }

        //머리 뻗고
        head[0] = y + dir[0];
        head[1] = x + dir[1];
        //몸통인 경우
        if (board[head[0]][head[1]] == -1) {
            return;
        }
        moved.add(new int[]{dir[0], dir[1]});

        //사과 확인
        if (board[head[0]][head[1]] != 1) {
            board[tail[0]][tail[1]] = 0;
            tail[0] += moved.peek()[0];
            tail[1] += moved.remove()[1];
        }
        board[head[0]][head[1]] = -1;

        //머리 틀고
        turn();
        time++;

        crawl(head[0], head[1]);
    }

    public void turn() {
        if (!apples.isEmpty() && apples.peek().time == time) {
            Apple apple = apples.remove();
            if (apple.dir == 'L') {
                int tmp = dir[0];
                dir[0] = -dir[1];
                dir[1] = tmp;
            } else {
                int tmp = dir[0];
                dir[0] = dir[1];
                dir[1] = -tmp;
            }
        }
    }

    public boolean canGo(int y, int x) {
        int nextY = y + dir[0];
        int nextX = x + dir[1];
        if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
            return false;
        }
        return true;
    }
}
class Apple {
    int time;
    char dir;

    Apple(int time, char dir) {
        this.time = time;
        this.dir = dir;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
머리가 몸과 부딪히는 경우에 머리와 꼬리의 충돌 여부만 확인하였음. 머리와 몸통 고려 추가
 */