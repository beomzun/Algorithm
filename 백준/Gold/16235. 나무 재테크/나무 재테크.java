import java.util.*;
import java.io.*;
class Solution {
    static int N;   //땅 크기
    static int M;   //첫 나무 수
    static int K;   //몇 년 후
    static int[][] A;   //추가 양분
    static int[][] medic;   //양분 양
    static int[][] dead;    //죽은 나무 양분
    static int[][] five;  //5배수 나이를 갖는 나무의 개수

    static PriorityQueue<int[]> trees = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
        }
    });

    public void solution() throws IOException {
        input();
        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }
    public void spring() {
        Queue<int[]> tmp = new ArrayDeque<>();
        while (!trees.isEmpty()) {
            int[] tree = trees.remove();
            int y = tree[0];
            int x = tree[1];
            int age = tree[2];
            if (age % 5 == 0) {
                five[y][x]--;
            }
            if (medic[y][x] >= age) {
                medic[y][x] -= age;
                tmp.add(new int[]{y, x, age + 1});
                if ((age + 1) % 5 == 0) {
                    five[y][x]++;
                }
            } else {
                dead[y][x] += age / 2;
            }
        }
        trees.addAll(tmp);
    }
    public void summer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                medic[i][j] += dead[i][j];
                dead[i][j] = 0;
            }
        }
    }

    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    public void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (five[i][j] > 0) {
                    for (int k = 0; k < 8; k++) {
                        int nowY = i + dy[k];
                        int nowX = j + dx[k];
                        if (nowY < 0 || nowY >= N || nowX < 0 || nowX >= N) {
                            continue;
                        }
                        for (int l = 0; l < five[i][j]; l++) {
                            trees.add(new int[]{nowY, nowX, 1});
                        }
                    }
                }
            }
        }
    }
    public void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                medic[i][j] += A[i][j];
            }
        }
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        medic = new int [N][N];
        dead = new int[N][N];
        five = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                medic[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new int[]{y, x, age});
            if (age % 5 == 0) {
                five[y][x]++;
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
