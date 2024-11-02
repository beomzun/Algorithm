import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[] numbers;
    static Map<Integer, Integer> numCount;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        numCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            numbers[i] = val;
            numCount.put(val, numCount.getOrDefault(val, 0) + 1);
        }
        Arrays.sort(numbers);

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            int sum = numbers[i];
            if (isGood(i, sum)) {
                ++count;
            }
        }
        System.out.println(count);
    }

    private boolean isGood(int i, int sum) {
        for (int j = N - 1; j >= 0; j--) {
            if (j == i) {
                continue;
            }
            int now = numbers[j];
            int target = sum - now;

            if (sum != 0 && now == 0) {
                if (numCount.get(sum) > 1) {
                    return true;
                }
                continue;
            }
            if (sum == 0 && now == 0) {
                if (numCount.get(sum) > 2) {
                    return true;
                }
                continue;
            }
            if (target == now || target == sum) {
                if (numCount.get(target) > 1) {
                    return true;
                }
            } else {
                if (numCount.containsKey(target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
