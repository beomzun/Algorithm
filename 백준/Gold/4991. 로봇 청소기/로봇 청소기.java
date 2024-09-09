import java.util.*;
import java.io.*;
class Solution {
    static int W;
    static int H;
    static char[][] room;
    static int dustCount = 0;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] dusts;
    static int[][] distance;
    static int minDist;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        while (true) {
            input();
            measureAllDistance();
            if(!canClean()){
                continue;
            }
            findMin(0, 0,0);
            bw.write(minDist + "\n");
        }
    }
    public boolean canClean() throws IOException {
        if (minDist == -1) {
            bw.write(-1 + "\n");
            return false;
        }
        return true;
    }

    public void findMin(int depth, int start, int sum) {
        if (depth == dustCount) {
            minDist = Math.min(minDist, sum);
            return;
        }
        for (int i = 1; i < dustCount + 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                findMin(depth + 1, i, sum + distance[start][i]);
                visit[i] = false;
            }
        }
    }

    public void measureAllDistance() {
        minDist = Integer.MAX_VALUE;
        distance = new int[dustCount + 1][dustCount + 1];
        for (int i = 0; i < dustCount; i++) {
            for (int j = i + 1; j <= dustCount; j++) {
                int dist = measureDistance(i, j);
                if (dist == -1) {
                    minDist = -1;
                    return;
                }
                distance[i][j] = dist;
                distance[j][i] = dist;
            }
        }
    }

    public int measureDistance(int start, int end) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[H][W];
        visit[dusts[start][0]][dusts[start][1]] = true;
        q.add(new int[]{dusts[start][0], dusts[start][1]});

        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] now = q.remove();
                for (int j = 0; j < 4; j++) {
                    int nY = now[0] + dy[j];
                    int nX = now[1] + dx[j];
                    if (isOut(nY, nX) || room[nY][nX] == 'x') {
                        continue;
                    }
                    if (!visit[nY][nX]) {
                        if (nY == dusts[end][0] && nX == dusts[end][1]) {
                            return dist;
                        }
                        visit[nY][nX] = true;
                        q.add(new int[]{nY, nX});
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    public boolean isOut(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        if (W == 0) {
            bw.flush();
            bw.close();
            System.exit(0);
        }

        room = new char[H][W];
        dustCount = 0;
        dusts = new int[11][2];
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                char val = s.charAt(j);
                room[i][j] = val;
                if (val == '*') {
                    dusts[++dustCount] = new int[]{i, j};
                }
                if (val == 'o') {
                    dusts[0] = new int[]{i, j};
                }
            }
        }
        visit = new boolean[dustCount + 1];
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
하나의 먼지를 찾았을 경우 큐와 방문 배열, 청소기 위치를 리셋.
거리 짧은 순으로 방문할 경우, 전체 시간이 길어질 수 있음
-> 해결 방법 떠오르지 않음.
---
전체 먼지 저장 후 -> 청소기와 먼지, 먼지-먼지 사이의 거리를 bfs 로 구하여 이들을 이차원 배열로 구성.
-> dfs 로 전체를 도는 최소 거리 도출
 */