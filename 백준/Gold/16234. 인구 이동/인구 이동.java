import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int L;
    static int R;
    static int[][] ground;
    static boolean[][] visit;
    static Stack<int[]> share = new Stack<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int sum;
    static boolean out;
    static int time = -1;

    public void solution() throws IOException {
        input();
        find();
        System.out.println(time);
    }
    public void find() {
        out = false;
        while(!out) {
            out = true;
            resetVisit();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) {
                        continue;
                    }
                    sum = ground[i][j];
                    visit[i][j] = true;
                    q.add(new int[]{i, j});
                    bfs();
                    distribute();
                }
            }
            time++;
        }
    }

    public void bfs() {
        while(!q.isEmpty()) {
            int[] point = q.remove();
            share.add(point);
            int i = point[0];
            int j = point[1];

            for (int k = 0; k < 4; k++) {
                int nextY = i + dy[k];
                int nextX = j + dx[k];
                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || visit[nextY][nextX]) {
                    continue;
                }
                int dif = Math.abs(ground[i][j] - ground[nextY][nextX]);
                if (dif >= L && dif <= R) {
                    visit[nextY][nextX] = true;
                    out = false;
                    q.add(new int[]{nextY, nextX});
                    sum += ground[nextY][nextX];
                }
            }
        }
    }

    public void distribute() {
        int size = share.size();
        int num = sum / size;
        while(!share.isEmpty()) {
            int[] point = share.pop();
            ground[point[0]][point[1]] = num;
        }
    }
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        ground = new int[N][N];
        visit = new boolean[N][N];
        resetVisit();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public void resetVisit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
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
좌상부터 방문하면서 bfs로 인구 비교 -> 차이가 범위에 속한다면 visit 체크표시 후 큐에 삽입. 이 때 인구수 합산. 큐에서 뺄 때 스택에 추가 = 추후 인구 평균작업 위함.
bfs 끊겼을때 스택에서 빼면서 인구 재분배. 방문배열을 통해 해당 회차에서 분배한 땅은 패스
 */