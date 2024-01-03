import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dis = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dis[i], MAX_VALUE);
            dis[i][i] = 0;
        }
        int start, des;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            des = Integer.parseInt(st.nextToken());
            dis[start][des] = Math.min(dis[start][des],Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dis[j][i] == MAX_VALUE) {
                    continue;
                }
                for (int k = 1; k <= n; k++) {
                    if (dis[i][k] == MAX_VALUE) {
                        continue;
                    }
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dis[i][j] == MAX_VALUE) {
                    dis[i][j] = 0;
                }
                bw.write(dis[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}