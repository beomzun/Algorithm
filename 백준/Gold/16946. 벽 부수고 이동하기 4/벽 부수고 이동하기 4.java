import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int M;
    static int[][] room;        //벽=1, 방=0 -> 방번호>=2
    static int[][] result;
    static boolean[][] visit;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int roomNumber = 2;
    Map<Integer, Integer> sizeMap = new HashMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                room[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 0) {
                    int roomSize = bfs(i, j);
                    sizeMap.put(roomNumber, roomSize);
                    roomNumber++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 1) {
                    result[i][j] = calculateMove(i, j);
                }
                bw.write(result[i][j] % 10 + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    public int calculateMove(int row, int col) {
        int count = 1;
        int[] visited = new int[4];
        for (int i = 0; i < 4; i++) {
            int nY = row + dy[i];
            int nX = col + dx[i];
            if (isOut(nY, nX)) {
                continue;
            }
            visited[i] = room[nY][nX];
        }
        Arrays.sort(visited);

        if (visited[0] >= 2) {
            count += sizeMap.get(visited[0]);
        }
        for (int i = 1; i < 4; i++) {
            if (visited[i] >= 2 && visited[i] != visited[i - 1]) {
                count += sizeMap.get(visited[i]);
            }
        }

        return count;
    }

    public int bfs(int row, int col) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});

        visit[row][col] = true;
        room[row][col] = roomNumber;
        int count = 1;
        while(!q.isEmpty()) {
            int[] now = q.remove();
            for (int i = 0; i < 4; i++) {
                int nY = now[0] + dy[i];
                int nX = now[1] + dx[i];
                if (isOut(nY, nX) || visit[nY][nX] || room[nY][nX] == 1) {
                    continue;
                }
                visit[nY][nX] = true;
                q.add(new int[]{nY, nX});
                room[nY][nX] = roomNumber;
                count++;
            }
        }

        return count;
    }

    public boolean isOut(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
벽 = 1
각 방마다 bfs 진행하여 방번호 부여. bfs 끝나면 해당 방번호의 크기가 몇인지 map에 저장
 */