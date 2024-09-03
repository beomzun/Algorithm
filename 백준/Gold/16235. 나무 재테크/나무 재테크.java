import java.util.*;
import java.io.*;
class Solution {
    static int N;   //땅 크기
    static int M;   //첫 나무 수
    static int K;   //몇 년 후
    static int[][] A;   //추가 양분
    static int[][] medic;   //양분 양
    static ArrayList<Integer>[][] trees;

    public void solution() throws IOException {
        input();
        for (int i = 0; i < K; i++) {
            spring();
            fall();
            winter();
        }

        System.out.println(countAlive());
    }
    public int countAlive() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += trees[i][j].size();
            }
        }
        return result;
    }

    public void spring() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!trees[i][j].isEmpty()) {
                    Collections.sort(trees[i][j]);
                    int dead = 0;
                    ArrayList<Integer> tmp = new ArrayList<>();
                    for (int age : trees[i][j]) {
                        if (medic[i][j] >= age) {
                            medic[i][j] -= age;
                            tmp.add(age + 1);
                        } else {
                            dead += age / 2;
                        }
                    }
                    trees[i][j] = tmp;
                    medic[i][j] += dead;
                }
            }
        }
    }
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    public void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int k = 0; k < 8; k++) {
                            int nowY = i + dy[k];
                            int nowX = j + dx[k];
                            if (nowY < 0 || nowY >= N || nowX < 0 || nowX >= N) {
                                continue;
                            }
                            trees[nowY][nowX].add(1);
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
        trees = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                medic[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[y][x].add(age);
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
static int N;   //땅 크기
    static int M;   //첫 나무 수
    static int K;   //몇 년 후
    static int[][] A;   //추가 양분
    static int[][] medic;   //양분 양
    static int[][] dead;    //죽은 나무 양분
    static int[][] five;  //5배수 나이를 갖는 나무의 개수
    를 사용하였으나, 최적에 비해 10배의 시간 소요..
---
개선
- dead 배열 + summer 메서드 제거 : 봄에서 계산 후 처리하도록
- 우선순위 큐 대신에 ArrayList 2차원 배열로 나무 관리
- 5배수도 따로 관리하지 않고, 모든 나무 하나로 관리
 */