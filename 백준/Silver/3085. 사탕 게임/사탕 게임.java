import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        int max=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<4;k++) {
                    int pY = i+dy[k];
                    int pX = j+dx[k];
                    if(pY<0||pY>=N||pX<0||pX>=N) {
                        continue;
                    }

                    char tmp = board[pY][pX];
                    board[pY][pX] = board[i][j];
                    board[i][j] = tmp;
                    char now = board[i][j];

                    //행 길이
                    int rowL = 1;
                    int right=j+1;
                    while(right<N) {
                        if(now==board[i][right]) {
                            rowL++;
                            right++;
                            continue;
                        }
                        break;
                    }
                    int left=j-1;
                    while(left>=0) {
                        if(now==board[i][left]) {
                            rowL++;
                            left--;
                            continue;
                        }
                        break;
                    }
                    max = Math.max(max,rowL);
                    //열 길이
                    int colL = 1;
                    int down = i + 1;
                    while(down<N) {
                        if(now==board[down][j]) {
                            down++;
                            colL++;
                            continue;
                        }
                        break;
                    }
                    int up = i - 1;
                    while(up>=0) {
                        if(now==board[up][j]) {
                            up--;
                            colL++;
                            continue;
                        }
                        break;
                    }
                    max = Math.max(max,colL);

                    tmp = board[pY][pX];
                    board[pY][pX] = board[i][j];
                    board[i][j] = tmp;
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
/*
네 방향 모두 바꾸기. 현재 칸의 행/열 길이 측정
 */