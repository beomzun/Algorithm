import java.util.*;
import java.io.*;
class Solution {
    Set<String> set = new HashSet<>();
    int[] dy = {-1,0,1,0};
    int[] dx = {0,-1,0,1};
    String[][] board = new String[5][5];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                board[i][j] = st.nextToken();
            }
        }

        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                dfs(i,j,0, board[i][j]);
            }
        }
        System.out.println(set.size());
    }
    public void dfs(int y, int x, int depth, String num) {
        if(depth==5) {
            set.add(num);
            return;
        }
        for(int i=0;i<4;i++) {
            int nY = y+dy[i];
            int nX = x+dx[i];
            if(nY<0||nY>4||nX<0||nX>4) {
                continue;
            }
            dfs(nY,nX,depth+1,num+board[nY][nX]);
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}