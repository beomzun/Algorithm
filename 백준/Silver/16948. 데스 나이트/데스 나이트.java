import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sR = Integer.parseInt(st.nextToken());
        int sC = Integer.parseInt(st.nextToken());
        int eR = Integer.parseInt(st.nextToken());
        int eC = Integer.parseInt(st.nextToken());
        if(sR==eR && sC==eC) {
            System.out.println(0);
            return;
        }

        boolean[][] visit = new boolean[N][N];
        visit[sR][sC] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sR,sC});
        int[] dy = {-2,-2,0,0,2,2};
        int[] dx = {-1,1,-2,2,-1,1};
        int time = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int[] now = q.remove();
                for(int i=0;i<6;i++) {
                    int nY = now[0]+dy[i];
                    int nX = now[1]+dx[i];
                    if(nY<0||nY>=N||nX<0||nX>=N || visit[nY][nX]) {
                        continue;
                    }
                    if(nY==eR && nX==eC) {
                        System.out.println(time);
                        return;
                    }
                    visit[nY][nX] = true;
                    q.add(new int[]{nY,nX});
                }
            }
            time++;
        }
        System.out.println(-1);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}