import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int INF = 100_000_000;
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        int test=1;
        while(N!=0) {
            int[][] room = new int[N][N];
            int[][] costs = new int[N][N];
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                    costs[i][j] = INF;
                }
            }

            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0,0});
            costs[0][0] = room[0][0];
            while(!q.isEmpty()) {
                int[] now = q.remove();
                int nowY = now[0];
                int nowX = now[1];
                for(int i=0;i<4;i++) {
                    int nY = nowY+dy[i];
                    int nX = nowX+dx[i];
                    if(nY<0||nY>=N||nX<0||nX>=N || costs[nY][nX]<=costs[nowY][nowX]+room[nY][nX]) {
                        continue;
                    }
                    costs[nY][nX] = costs[nowY][nowX] + room[nY][nX];
                    q.add(new int[]{nY,nX});
                }
            }

            sb.append("Problem " + test + ": " + costs[N - 1][N - 1] + "\n");
            test++;
            N = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

