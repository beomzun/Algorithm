import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> counts = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            q.add(val);
            counts.put(val, counts.getOrDefault(val, 0) + 1);
            if (counts.get(val) == 1) {
                while (counts.size() > 2) {
                    int outVal = q.remove();
                    counts.replace(outVal, counts.get(outVal) - 1);
                    if (counts.get(outVal) == 0) {
                        counts.remove(outVal);
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