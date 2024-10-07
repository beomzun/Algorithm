import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int result = Integer.parseInt(br.readLine());
            int[] counts = new int[result + 1];
            counts[0] = 1;
            for (int j = 0; j < N; j++) {
                for (int k = coins[j]; k <= result; k++) {
                    counts[k] += counts[k - coins[j]];
                }
            }

            bw.write(counts[result] + "\n");
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
/*
현재 금액에서 해당 동전의 값을 뺀만큼의 값을 만들수있는 경우의 수 +1
1 2 1000
counts 1 1 1 1 1 ...
       1 1 2 2 3 3 ...
 */