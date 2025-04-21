import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] disArr = new int[N][M];
        for(int i=0;i<N;i++) {
            Arrays.fill(disArr[i],-1);
        }

        boolean[][] room = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    room[i][j] = true;
                    disArr[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int max = 0;
        int[] dy = {-1,-1,0,1,1,1,0,-1};
        int[] dx = {0,-1,-1,-1,0,1,1,1};
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int nowY = now[0];
            int nowX = now[1];

            for(int i=0;i<8;i++) {
                int nY = nowY+dy[i];
                int nX = nowX+dx[i];
                if(nY<0||nY>=N||nX<0||nX>=M || disArr[nY][nX]!=-1) {
                    continue;
                }
                disArr[nY][nX] = disArr[nowY][nowX]+1;
                max = Math.max(max, disArr[nY][nX]);
                q.add(new int[]{nY,nX});
            }
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
