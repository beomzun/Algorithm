import java.util.*;
import java.io.*;
class Solution {
    static int W;
    static int H;
    static boolean[][] wall;
    static int endR = -1;
    static int endC = -1;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        wall = new boolean[H][W];
        boolean start = true;
        int startR = -1;
        int startC = -1;

        for(int i=0;i<H;i++) {
            String s = br.readLine();
            for(int j=0;j<W;j++) {
                char c = s.charAt(j);
                if(c=='C') {
                    if(start) {
                        startR = i;
                        startC = j;
                        start = false;
                    } else {
                        endR = i;
                        endC = j;
                    }
                    continue;
                }
                if(c=='*') {
                    wall[i][j] = true;
                }
            }
        }

        int[][][] dis = new int[H][W][4];
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                Arrays.fill(dis[i][j], 10_000);
            }
        }


        Deque<int[]> d = new ArrayDeque<>();
        for(int i=0;i<4;i++) {
            dis[startR][startC][i] = 0;
            d.add(new int[]{startR, startC, i});
        }

        while(!d.isEmpty()) {
            int[] now = d.removeFirst();
            int pastCount = dis[now[0]][now[1]][now[2]];
            for(int i=0;i<4;i++) {
                if (i != now[2] && (i + now[2]) % 2 == 0) {
                    continue;
                }

                int nY = now[0] + dy[i];
                int nX = now[1] + dx[i];
                if (nY < 0 || nY >= H || nX < 0 || nX >= W || wall[nY][nX]) {
                    continue;
                }
                if (i == now[2]) {
                    if(dis[nY][nX][i] > pastCount) {
                        dis[nY][nX][i] = pastCount;
                        d.addFirst(new int[]{nY, nX, i});
                    }
                } else {
                    if (dis[nY][nX][i] > pastCount + 1) {
                        dis[nY][nX][i] = pastCount + 1;
                        d.addLast(new int[]{nY, nX, i});
                    }
                }
            }
        }

        int min = 10_000;
        for(int i=0;i<4;i++) {
            min = Math.min(min, dis[endR][endC][i]);
        }
        System.out.println(min);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
dfs로 진행하면서 도착시 꺾인횟수 작은것
---
시간초과
반대방향 막기.
---
0-1 BFS
 */