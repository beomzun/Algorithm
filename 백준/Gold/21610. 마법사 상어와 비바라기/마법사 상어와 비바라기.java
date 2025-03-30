import java.util.*;
import java.io.*;
class Solution {
    int N;
    int[][] board;
    boolean[][] visit;
    int[] dy = {0,-1,-1,-1,0,1,1,1};
    int[] dx = {-1,-1,0,1,1,1,0,-1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<int[]> clouds = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();
        clouds.add(new int[]{N-2,0});
        clouds.add(new int[]{N-2,1});
        clouds.add(new int[]{N-1,0});
        clouds.add(new int[]{N-1,1});

        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken()) % N;
            for(int[] c : clouds) {
                c[0] = (c[0] + dy[d] * s + N) % N;
                c[1] = (c[1] + dx[d] * s + N) % N;
                board[c[0]][c[1]]++;
            }

            for(int[] c : clouds) {
                plus.add(calPlusCount(c[0],c[1]));
            }
            for(int i=0;i<clouds.size();i++) {
                int[] cloud = clouds.get(i);
                board[cloud[0]][cloud[1]] += plus.get(i);
                visit[cloud[0]][cloud[1]] = true;
            }

            clouds.clear();
            plus.clear();
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visit[i][j] || board[i][j]<2) {
                        visit[i][j] = false;
                        continue;
                    }
                    clouds.add(new int[]{i,j});
                    board[i][j]-=2;
                }
            }
        }

        int total = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                total += board[i][j];
            }
        }
        System.out.println(total);
    }

    int[] diagY = {-1,-1,1,1};
    int[] diagX = {-1,1,-1,1};
    public int calPlusCount(int row, int col) {
        int count=0;
        for(int i=0;i<4;i++) {
            int nY = row+diagY[i];
            int nX = col+diagX[i];
            if (nY >= 0 && nY < N && nX >= 0 && nX < N && board[nY][nX] > 0) {
                count++;
            }
        }
        return count;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1->N->1 : 이동만 연결, 대각선은 아님.
 */