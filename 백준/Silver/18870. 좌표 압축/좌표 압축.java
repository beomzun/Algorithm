import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        ArrayList<Integer> orders = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            orders.add(val);
            numbers[i] = val;
        }
        Arrays.sort(numbers);

        int priority = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : numbers) {
            if (!map.containsKey(val)) {
                map.put(val, priority++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : orders) {
            sb.append(map.get(val)).append(" ");
        }
        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
