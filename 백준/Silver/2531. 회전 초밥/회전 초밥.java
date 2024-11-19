import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int[] counts = new int[d + 1];
        int kind = 0;
        int maxKind = 0;
        int start = 0;
        int end = start - k;
        for (; end < N; start++, end++) {
            start %= N;
            int num = sushi[start];
            if (counts[num] == 0) {
                kind++;
            }
            counts[num]++;
            if (end < 0) {
                if (end == -1) {
                    if (counts[c] == 0) {
                        maxKind = Math.max(maxKind, kind + 1);
                    } else {
                        maxKind = Math.max(maxKind, kind);
                    }
                }
                continue;
            }
            int outNum = sushi[end];
            counts[outNum]--;
            if (counts[outNum] == 0) {
                kind--;
            }
            if (counts[c] == 0) {
                maxKind = Math.max(maxKind, kind + 1);
            } else {
                maxKind = Math.max(maxKind, kind);
            }
        }

        System.out.println(maxKind);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}