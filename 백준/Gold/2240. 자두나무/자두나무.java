import java.util.*;
import java.io.*;
class Solution {
    static int[][] JD;
    static int T;
    static int max = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());   // 떨어지는 횟수,시간
        int W = Integer.parseInt(st.nextToken());   // 최대 움직임 횟수
        // row 가 T일 때, W번 움직였을 때의 먹은 개수 -> W%2==0 현재위치 1, 홀수면 2
        JD = new int[T + 1][W + 1];
        for (int i = 1; i <= T; i++) {
            int nowPos = Integer.parseInt(br.readLine());
            for (int j = 0; j <= W; j++) {
                //j번 움직였을때 현재 위치에 자두가 떨어진다면
                if ((j % 2) + 1 == nowPos) {
                    //가만하서서 먹거나
                    JD[i][j] = Math.max(JD[i][j], JD[i - 1][j] + 1);
                    //움직여서 안먹거나
                    if (j < W) {
                        JD[i][j + 1] = Math.max(JD[i][j + 1], JD[i - 1][j]);
                    }
                } else {
                    //움직여서 먹거나
                    if (j < W) {
                        JD[i][j + 1] = Math.max(JD[i][j + 1], JD[i - 1][j] + 1);
                    }
                    //가만히서서 안먹거나
                    JD[i][j] = Math.max(JD[i][j], JD[i - 1][j]);
                }
            }
        }
        for (int val : JD[T]) {
            max = Math.max(max, val);
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
dfs 로 수행 -> 시간초과
 */