import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        PriorityQueue<int[]> virus = new PriorityQueue<>((v1,v2)-> v1[0]-v2[0]);
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
                if (val != 0) {
                    virus.add(new int[]{val, i, j});
                }
            }
        }
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;
        int Y = Integer.parseInt(st.nextToken())-1;
        while(S-->0) {
            ArrayList<int[]> tmp = new ArrayList<>();
            int size = virus.size();
            while(size-->0) {
                int[] v = virus.remove();
                for(int i=0;i<4;i++) {
                    int nY = v[1]+dy[i];
                    int nX = v[2]+dx[i];
                    if(nY<0||nY>=N||nX<0||nX>=N || board[nY][nX]!=0) {
                        continue;
                    }
                    board[nY][nX] = v[0];
                    tmp.add(new int[]{v[0],nY,nX});
                }
            }
            virus.addAll(tmp);
        }
        System.out.println(board[X][Y]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
바이러스 종류 K개
증식시 낮은 번호의 바이러스부터 증식
 */