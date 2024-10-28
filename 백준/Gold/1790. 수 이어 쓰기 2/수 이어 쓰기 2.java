import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int pow = 0;
        int count = 0;
        while (true) {
            if (Math.pow(10, pow) > N) {
                System.out.println(-1);
                return;
            }
            int start = (int) Math.pow(10, pow);
            int end = start * 10;
            for (int i = start; i < end && i <= N; i++) {
                if (count + (pow + 1) >= K) {
                    String target = String.valueOf(i);
                    System.out.println(target.charAt(K - count - 1));
                    return;
                }
                count += (pow + 1);
            }
            pow++;
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
1 : 1-9 = 9개 * 1
2 : 10-99 = 90개 * 2
3 : 100-999 = 0-899 = 900개 * 3
4 : 1000-9999 = 9000개 * 4
...
9 : 900000000 * 9 = 81억
 */