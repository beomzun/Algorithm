import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> cards = new HashMap<>();

        long result = (long) -Math.pow(2, 62);
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(br.readLine());
            int count = cards.getOrDefault(val, 0);
            cards.put(val, count + 1);
            if (count + 1 > maxCount) {
                result = val;
                maxCount = count + 1;
                continue;
            }
            if (count + 1 == maxCount && val < result) {
                result = val;
            }
        }

        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
