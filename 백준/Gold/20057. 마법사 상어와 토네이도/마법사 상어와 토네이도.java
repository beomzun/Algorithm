import java.util.*;
import java.io.*;
class Solution {
    int N;
    int[][] board;
    int nowR;
    int nowC;
    int count = 1;
    int answer = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        nowR = N/2;
        nowC = N/2;
        while(true) {
            left();
            if(nowR==0&&nowC==0) {
                break;
            }
            down();

            count++;

            right();
            up();
            if(count==N-1) {
                continue;
            }
            count++;
        }
        System.out.println(answer);
    }
    int[] dy = {-1,1,-1,1,-2,2,-1,1,0,0};
    int[] dx = {1,1,0,0,0,0,-1,-1,-2,-1};
    int[] mod = {1,1,7,7,2,2,10,10,5};
    public void left() {
        int rec = count;
        while(rec-->0) {
            nowC--;
            int base = board[nowR][nowC];
            int moveTotal = 0;
            for(int i=0;i<9;i++) {
                int nY = nowR+dy[i];
                int nX = nowC+dx[i];
                int move = base*mod[i]/100;
                moveTotal += move;
                if(nY<0||nY>=N||nX<0||nX>=N) {
                    answer += move;
                    continue;
                }
                board[nY][nX] += move;
            }
            int nY = nowR+dy[9];
            int nX = nowC+dx[9];
            int move = base - moveTotal;
            board[nowR][nowC] = 0;
            if(nY<0||nY>=N||nX<0||nX>=N) {
                answer += move;
                return;
            }
            board[nY][nX] += move;
        }
    }
    public void down() {
        int rec = count;
        while(rec-->0) {
            nowR++;
            int base = board[nowR][nowC];
            int moveTotal = 0;
            for(int i=0;i<9;i++) {
                int nY = nowR-dx[i];
                int nX = nowC+dy[i];
                int move = base*mod[i]/100;
                moveTotal += move;
                if(nY<0||nY>=N||nX<0||nX>=N) {
                    answer += move;
                    continue;
                }
                board[nY][nX] += move;
            }
            int nY = nowR-dx[9];
            int nX = nowC+dy[9];
            int move = base - moveTotal;
            board[nowR][nowC] = 0;
            if(nY<0||nY>=N||nX<0||nX>=N) {
                answer += move;
                return;
            }
            board[nY][nX] += move;
        }
    }
    public void right() {
        int rec = count;
        while(rec-->0) {
            nowC++;
            int base = board[nowR][nowC];
            int moveTotal = 0;
            for(int i=0;i<9;i++) {
                int nY = nowR+dy[i];
                int nX = nowC-dx[i];
                int move = base*mod[i]/100;
                moveTotal += move;
                if(nY<0||nY>=N||nX<0||nX>=N) {
                    answer += move;
                    continue;
                }
                board[nY][nX] += move;
            }
            int nY = nowR+dy[9];
            int nX = nowC-dx[9];
            int move = base - moveTotal;
            board[nowR][nowC] = 0;
            if(nY<0||nY>=N||nX<0||nX>=N) {
                answer += move;
                return;
            }
            board[nY][nX] += move;
        }
    }
    public void up() {
        int rec = count;
        while(rec-->0) {
            nowR--;
            int base = board[nowR][nowC];
            int moveTotal = 0;
            for(int i=0;i<9;i++) {
                int nY = nowR+dx[i];
                int nX = nowC+dy[i];
                int move = base*mod[i]/100;
                moveTotal += move;
                if(nY<0||nY>=N||nX<0||nX>=N) {
                    answer += move;
                    continue;
                }
                board[nY][nX] += move;
            }
            int nY = nowR+dx[9];
            int nX = nowC+dy[9];
            int move = base - moveTotal;
            board[nowR][nowC] = 0;
            if(nY<0||nY>=N||nX<0||nX>=N) {
                answer += move;
                return;
            }
            board[nY][nX] += move;
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
시작 N/2,N/2
움직임 : 좌1 하1 우2 상2 좌3 하3 우4 상4 => 0,0까지
한번 움직이면 10번의 분해
 */