import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        while(T-->0) {
            int minY=0;
            int minX=0;
            int maxY=0;
            int maxX=0;
            int dir=0;
            int nowY=0;
            int nowX=0;

            String comm = br.readLine();
            for(int j=0;j<comm.length();j++) {
                char c = comm.charAt(j);
                if(c=='F') {
                    nowY+=dy[dir];
                    nowX+=dx[dir];
                } else if(c=='B') {
                    nowY-=dy[dir];
                    nowX-=dx[dir];
                } else if(c=='L') {
                    if(dir==0) {
                        dir=3;
                    } else {
                        dir--;
                    }
                } else if(c=='R') {
                    if(dir==3) {
                        dir=0;
                    } else {
                        dir++;
                    }
                }

                minY = Math.min(minY, nowY);
                minX = Math.min(minX, nowX);
                maxY = Math.max(maxY, nowY);
                maxX = Math.max(maxX, nowX);
            }
            sb.append((Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY)))
                    .append("\n");
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

