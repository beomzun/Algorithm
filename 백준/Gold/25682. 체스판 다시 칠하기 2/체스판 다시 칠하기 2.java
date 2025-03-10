import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] board = new char[N+1][M+1];
        for(int i=1;i<=N;i++) {
            String s = br.readLine();
            for(int j=1;j<=M;j++) {
                board[i][j] = s.charAt(j-1);
            }
        }

        int[][] count = new int[N+1][M+1];
        //짝수 검정
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                count[i][j] = count[i-1][j] + count[i][j-1] - count[i-1][j-1];

                if((i+j)%2==0) {
                    if (board[i][j] == 'W') {
                        count[i][j]++;
                    }
                } else {
                    if(board[i][j] == 'B') {
                        count[i][j]++;
                    }
                }
            }
        }
        int min = N*M;
        for(int i=K;i<=N;i++) {
            for(int j=K;j<=M;j++) {
                int nowCount = count[i][j] - count[i - K][j] - count[i][j - K] + count[i - K][j - K];
                min = Math.min(min, nowCount);
            }
        }

        //짝수 하양
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                count[i][j] = count[i-1][j] + count[i][j-1] - count[i-1][j-1];

                if((i+j)%2==0) {
                    if (board[i][j] == 'B') {
                        count[i][j]++;
                    }
                } else {
                    if(board[i][j] == 'W') {
                        count[i][j]++;
                    }
                }
            }
        }

        for(int i=K;i<=N;i++) {
            for(int j=K;j<=M;j++) {
                int nowCount = count[i][j] - count[i - K][j] - count[i][j - K] + count[i - K][j - K];
                min = Math.min(min, nowCount);
            }
        }

        System.out.println(min);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
K,K부터 시작.
시작이 검정
- 자신의 앞쪽애들에서 짝수인덱스 검정개수확인 / 홀수인덱스 하양개수확인 (MN)
-> 바꿔야하는 개수 확인해서 검정+하양 -> 최소값 찾기
시작이 하양
- 위 반복
 */