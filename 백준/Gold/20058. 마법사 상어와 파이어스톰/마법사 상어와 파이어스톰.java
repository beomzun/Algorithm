import java.util.*;
import java.io.*;
class Solution {
    int N;
    int[][] board;
    int[] dy = {-1,0,1,0};
    int[] dx = {0,-1,0,1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2,N);
        board = new int[N][N];
        for(int i=0;i< N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j< N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] qArr = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++) {
            qArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int q =0;q<Q;q++) {
            board = divide(qArr[q]);
            board = melt();
        }

        int total = 0;
        int max = 0;
        boolean[][] visit = new boolean[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visit[i][j] || board[i][j]==0) {
                    continue;
                }
                visit[i][j] = true;
                int length = 0;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                while(!q.isEmpty()) {
                    int[] now = q.remove();
                    length++;
                    total += board[now[0]][now[1]];
                    for(int k=0;k<4;k++) {
                        int nY = now[0]+dy[k];
                        int nX = now[1]+dx[k];
                        if(nY<0||nY>= N ||nX<0||nX>= N || visit[nY][nX] || board[nY][nX]==0) {
                            continue;
                        }
                        visit[nY][nX]=true;
                        q.add(new int[]{nY,nX});
                    }
                }
                max = Math.max(max, length);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n").append(max);
        System.out.println(sb);
    }
    public int[][] divide(int size) {
        int[][] tmp = new int[N][N];
        size = (int) Math.pow(2,size);
        for(int i=0;i<N;i+=size) {
            for(int j=0;j<N;j+=size) {
                rotate(i,j,size,tmp);
            }
        }
        return tmp;
    }

    public void rotate(int y, int x, int size, int[][] tmp) {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                tmp[y+i][x+j] = board[y+size-1-j][x+i];
            }
        }
    }

    public int[][] melt() {
        int[][] tmp = new int[N][N];
        for(int i=0;i< N;i++) {
            tmp[i] = Arrays.copyOf(board[i], N);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                if (board[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nY = i + dy[k];
                    int nX = j + dx[k];
                    if(nY<0||nY>= N ||nX<0||nX>= N || board[nY][nX]==0) {
                        continue;
                    }
                    count++;
                }
                if(count<3) {
                    tmp[i][j]--;
                }
            }
        }
        return tmp;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
n=6 2^12 * 4 * Q
사이즈가 2면 1번사용 \ 4면 3번 사용 \ 8이면 7번 사용
8의 경우
- 00->07, 10->06, 20->05, 30->04 .. 60->01, 70->00
-
 */