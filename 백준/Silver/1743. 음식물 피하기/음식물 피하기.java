import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] room = new boolean[N+1][M+1];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            room[r][c] = true;
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        int max = 0;
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if(room[i][j]) {
                    int count = 1;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i,j});
                    room[i][j] = false;
                    while(!q.isEmpty()) {
                        int[] now = q.remove();
                        int y = now[0];
                        int x = now[1];

                        for(int k=0;k<4;k++) {
                            int nY = y+dy[k];
                            int nX = x+dx[k];
                            if(nY<=0||nY>N||nX<=0||nX>M || !room[nY][nX]) {
                                continue;
                            }
                            room[nY][nX] = false;
                            q.add(new int[]{nY,nX});
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                }
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