import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] earth = new char[R][C];
        for(int i=0;i<R;i++) {
            String s = br.readLine();
            for(int j=0;j<C;j++) {
                earth[i][j] = s.charAt(j);
            }
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(earth[i][j]=='.') {
                    continue;
                }
                int count = 0;
                for(int k=0;k<4;k++) {
                    int nY = i+dy[k];
                    int nX = j+dx[k];
                    if(nY<0||nY>=R||nX<0||nX>=C || earth[nY][nX]=='.') {
                        count++;
                    }
                }
                if(count>=3) {
                    earth[i][j] = '0';
                }
            }
        }

        int startY = 10;
        int startX = 10;
        int endY = 0;
        int endX = 0;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(earth[i][j]=='X') {
                    startY = Math.min(startY, i);
                    endY = Math.max(endY, i);
                    startX = Math.min(startX, j);
                    endX = Math.max(endX, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=startY;i<=endY;i++) {
            for(int j=startX;j<=endX;j++) {
                if(earth[i][j]=='0') {
                    earth[i][j]='.';
                }
                sb.append(earth[i][j]);
            }
            sb.append("\n");
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
