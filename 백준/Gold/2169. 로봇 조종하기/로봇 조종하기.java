import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] worths = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                worths[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] max = new int[N][M];
        max[0][0] = worths[0][0];
        for(int i=1;i<M;i++) {
            max[0][i] += max[0][i-1] + worths[0][i];
        }
        for(int i=1;i<N;i++) {
            int[][] tmp = new int[2][M];
            tmp[0][0] = max[i-1][0] + worths[i][0];
            for(int j=1;j<M;j++) {
                tmp[0][j] = Math.max(tmp[0][j-1], max[i-1][j]) + worths[i][j];
            }

            tmp[1][M-1] = max[i-1][M-1] + worths[i][M-1];
            for(int j=M-2;j>=0;j--) {
                tmp[1][j] = Math.max(tmp[1][j+1], max[i-1][j]) + worths[i][j];
            }

            for(int j=0;j<M;j++) {
                max[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }

        System.out.println(max[N-1][M-1]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
로봇은 1,1에서 N,M으로 향한다.
좌우하로 이동할수있지만, 상으로는 이동할수없다. 한 번 탐사한 지역은 탐사하지 않는다.
각 칸마다 탐사 가치가 있다.
탐사 가치가 최대가 되도록 탐사 진행.
---
좌상 \ 우상 => 최대값
 */
