import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ladders = new int[N][3];
        int[][] maxL = new int[N][3];
        int[][] minL = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                ladders[i][j] = Integer.parseInt(st.nextToken());
                maxL[i][j] = ladders[i][j];
                minL[i][j] = ladders[i][j];
            }
        }

        for (int i = 1; i < N; i++) {
            maxL[i][0] += Math.max(maxL[i - 1][0], maxL[i - 1][1]);
            maxL[i][1] += Math.max(maxL[i - 1][0], Math.max(maxL[i - 1][1], maxL[i - 1][2]));
            maxL[i][2] += Math.max(maxL[i - 1][1], maxL[i - 1][2]);

            minL[i][0] += Math.min(minL[i - 1][0], minL[i - 1][1]);
            minL[i][1] += Math.min(minL[i - 1][0], Math.min(minL[i - 1][1], minL[i - 1][2]));
            minL[i][2] += Math.min(minL[i - 1][1], minL[i - 1][2]);
        }
        int max = Math.max(maxL[N - 1][0], Math.max(maxL[N - 1][1], maxL[N - 1][2]));
        int min = Math.min(minL[N - 1][0], Math.min(minL[N - 1][1], minL[N - 1][2]));

        System.out.println(max + " " + min);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1차원 배열에서와 다르게 2차원 배열에서의 clone 시 얕은 복사로 주소 공유함
 */