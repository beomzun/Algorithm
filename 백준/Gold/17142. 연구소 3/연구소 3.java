import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int M;
    static int[][] arr;
    static Virus[] active;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Virus> viruses = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int originEmptySpace = 0;

    public void solution() throws IOException {
        input();
        if (originEmptySpace == 0) {
            System.out.println(0);
        } else {
            combination(0,0);
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }

    public void combination(int depth, int count) {
        if (depth == M) {
            spread(originEmptySpace);
            return;
        }

        for (int i = count; i < viruses.size(); i++) {
            active[depth] = viruses.get(i);
            combination(depth + 1, i + 1);
        }
    }

    public void spread(int emptyCount) {
        Queue<Virus> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            Virus virus = active[i];
            visit[virus.y][virus.x] = true;
            q.add(virus);
        }

        while (!q.isEmpty()) {
            Virus virus = q.remove();
            for (int i = 0; i < 4; i++) {
                int nY = virus.y + dy[i];
                int nX = virus.x + dx[i];
                if (isOut(nY, nX)) {
                    continue;
                }
                if (visit[nY][nX] || arr[nY][nX] == 1) {
                    continue;
                }
                if (arr[nY][nX] == 0) {
                    emptyCount--;
                }
                if (emptyCount == 0) {
                    min = Math.min(min, virus.time + 1);
                    return;
                }

                visit[nY][nX]=true;
                q.add(new Virus(nY, nX, virus.time + 1));
            }
        }
    }

    public boolean isOut(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        active = new Virus[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 0) {
                    originEmptySpace++;
                } else if (arr[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                }
            }
        }
    }
}
class Virus {
    int y;
    int x;
    int time;
    Virus(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}