import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int[] canSee = new int[N];
        for (int i = 0; i < N; i++) {
            double incline = -1_000_000_000;
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                double nowInc = (double) (buildings[j] - buildings[i]) / (j - i);
                if (nowInc > incline) {
                    incline = nowInc;
                    count++;
                    canSee[j]++;
                }
            }
            canSee[i] += count;
            max = Math.max(max, canSee[i]);
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
