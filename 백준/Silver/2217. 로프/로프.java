import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope, Collections.reverseOrder());

        int max = rope[0];
        for (int i = 1; i < N; i++) {
            int now = rope[i] * (i + 1);
            max = Math.max(max, now);
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
/*
1개 - 로프무게
2개 - 제일작은 로프의*2 무게
 */