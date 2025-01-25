import java.util.*;
import java.io.*;
class Solution {
    int N;
    int M;
    int[][] room;
    boolean[][] visit;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        int cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) {
                    continue;
                }
                //치즈는 아니지만, 내부에 있고 방문하지 않았을 때 벽이다. 경계에 붙어있다면 외부
                if (room[i][j] == 0) {
                    if (i > 0 && i < N - 1 && j > 0 && j < M - 1) {
                        findWall(i, j);
                        continue;
                    }
                    findOut(i, j);
                }
            }
        }

        int time = 0;
        Queue<int[]> outCheese = new ArrayDeque<>();
        while (cheeseCount != 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (room[i][j] == 1) {
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int nY = i + dy[k];
                            int nX = j + dx[k];
                            if (i == 0 || i == N - 1 || j == 0 || j == M - 1 || room[nY][nX] == 0) {
                                count++;
                            }
                        }
                        if (count >= 2) {
                            outCheese.add(new int[]{i, j});
                            visit[i][j] = true;
                        }
                    }
                }
            }
            while (!outCheese.isEmpty()) {
                int[] cheese = outCheese.remove();
                int y = cheese[0];
                int x = cheese[1];
                room[y][x] = 0;
                for (int i = 0; i < 4; i++) {
                    int nY = y + dy[i];
                    int nX = x + dx[i];
                    if (nY < 0 || nY >= N || nX < 0 || nX >= M) {
                        continue;
                    }
                    if (room[nY][nX] == 2) {
                        breakWall(nY, nX);
                    }
                }
                cheeseCount--;
            }
            time++;
        }
        System.out.println(time);
    }

    public void breakWall(int row, int col) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        room[row][col] = 0;
        while(!q.isEmpty()) {
            int[] now = q.remove();
            for (int i = 0; i < 4; i++) {
                int nY = now[0] + dy[i];
                int nX = now[1] + dx[i];
                if (nY < 0 || nY >= N || nX < 0 || nX >= M) {
                    continue;
                }
                if (room[nY][nX] == 2) {
                    q.add(new int[]{nY, nX});
                    room[nY][nX] = 0;
                }
            }
        }
    }
    public void findWall(int row, int col) {
        visit[row][col] = true;
        room[row][col] = 2;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        while(!q.isEmpty()) {
            int[] now = q.remove();
            for (int i = 0; i < 4; i++) {
                int nY = now[0] + dy[i];
                int nX = now[1] + dx[i];
                if (nY < 0 || nY >= N || nX < 0 || nX >= M || visit[nY][nX]) {
                    continue;
                }
                if (room[nY][nX] == 0) {
                    visit[nY][nX] = true;
                    room[nY][nX] = 2;
                    q.add(new int[]{nY, nX});
                }
            }
        }
    }
    public void findOut(int row, int col) {
        visit[row][col] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] now = q.remove();
            for (int i = 0; i < 4; i++) {
                int nY = now[0] + dy[i];
                int nX = now[1] + dx[i];
                if (nY < 0 || nY >= N || nX < 0 || nX >= M || visit[nY][nX]) {
                    continue;
                }
                if (room[nY][nX] == 0) {
                    visit[nY][nX] = true;
                    q.add(new int[]{nY, nX});
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
첫 NM 때 - 외부 치즈 확인, 방들 확인, 외부와 붙어있으면 0
외부0, 치즈1, 벽2
다음부터 - 외부 치즈 제거 시 주변에 방이 있다면 bfs로 해당 방 제거
 */