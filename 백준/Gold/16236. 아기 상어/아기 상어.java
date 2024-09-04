import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[][] sea;
    static int nowY;
    static int nowX;
    static int nextY;
    static int nextX;
    static int age = 2;
    static int feed = 0;
    static int time = 0;

    public void solution() throws IOException {
        input();
        start();
        System.out.println(time);
    }

    public void start() {
        while (find()) {
            feed++;
            if (feed == age) {
                age++;
                feed = 0;
            }
        }
    }

    public boolean find() {
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> tmpRoad = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int dis = 1;

        q.add(new int[]{nowY, nowX});
        visit[nowY][nowX] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] tmpNow = q.remove();
                for (int j = 0; j < 4; j++) {
                    nextY = tmpNow[0] + dy[j];
                    nextX = tmpNow[1] + dx[j];
                    if (outIndex()) {
                        continue;
                    }
                    if (!visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        int val = sea[nextY][nextX];
                        //지나갈 수 있으면
                        if (val <= age) {
                            tmpRoad.add(new int[]{nextY, nextX, val});
                        }
                    }
                }
            }

            while (!tmpRoad.isEmpty()) {
                int[] priority = tmpRoad.remove();
                nextY = priority[0];
                nextX = priority[1];
                int val = priority[2];
                //먹기
                if (val < age && val > 0) {
                    sea[nextY][nextX] = 0;
                    nowY = nextY;
                    nowX = nextX;
                    time += dis;
                    return true;
                }
                //지나가기
                if (val == age || val == 0) {
                    q.add(new int[]{nextY, nextX});
                }
            }
            dis++;
        }
        return false;
    }

    public boolean outIndex() {
        return nextY < 0 || nextY >= N || nextX < 0 || nextX >= N;
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sea = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    sea[i][j] = 0;
                    nowY = i;
                    nowX = j;
                    nextY = i;
                    nextX = j;
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
먹을 수 없으면 종료. 버틴 시간 출력
가장 가까운 물고기 먹으러 가기. 우선순위는 거리, y가 작고, 같다면 x가 작은. 위좌우 탐색
한 칸 이동당 1초걸림.
물고기는 먹히면 사라짐.
먹을 수 있는게 있나? 갈수있나?
마름모 모양으로 상좌우하 탐색 -> 갈수있는지 확인 -> 반복
---
이었으나 처음부터 bfs 적용 시 0이거나 같으면 큐에 넣고 작은수만나면 먹고 반복. 이 떠오름
---
상좌우하 탐색 시 첫번째 탐색에서는 동작하지만, 두번째 바퀴에서 좌하 와 우우 가 같은 값이면 좌하를 먼저 발견하는 버그
-> 우선순위 큐를 사용하여 현재 거리에서 가능한 모든 녀석들을 정렬하여 큐에 삽입.  
 */