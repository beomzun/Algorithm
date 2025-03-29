import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        char[][] board = new char[row][col];
        for(int i=0;i<row;i++) {
            String s = br.readLine();
            for(int j=0;j<col;j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int blue = 0;
        int white = 0;
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i][j]=='R') {
                    continue;
                }
                int count = 1;
                boolean isBlue = board[i][j]=='B';
                board[i][j] = 'R';
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                while(!q.isEmpty()) {
                    int[] now = q.remove();
                    for(int k=0;k<4;k++) {
                        int nY = now[0] + dy[k];
                        int nX = now[1] + dx[k];
                        if(nY<0||nY>=row||nX<0||nX>=col || board[nY][nX]=='R') {
                            continue;
                        }
                        if(isBlue && board[nY][nX]!='B' || !isBlue && board[nY][nX]=='B') {
                            continue;
                        }
                        board[nY][nX]='R';
                        count++;
                        q.add(new int[]{nY,nX});
                    }
                }
                if(isBlue) {
                    blue += Math.pow(count,2);
                } else {
                    white += Math.pow(count,2);
                }
            }
        }

        System.out.println(white + " " + blue);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}