import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] counts = new int[10];
        Queue<Integer> q = new ArrayDeque<>();
        int max = 0;
        int kind = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            q.add(val);
            counts[val]++;
            if (counts[val] == 1) {
                kind++;
                while (kind > 2) {
                    int outVal = q.remove();
                    counts[outVal]--;
                    if (counts[outVal] == 0) {
                        kind--;
                        break;
                    }
                }
            }
            max = Math.max(max, q.size());
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