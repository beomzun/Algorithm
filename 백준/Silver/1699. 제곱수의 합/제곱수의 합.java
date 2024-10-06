import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N + 1];     //정답
        Arrays.fill(numbers, N);
        numbers[0] = numbers[1] = 1;

        for (int i = 1; i <= Math.sqrt(N); i++) {
            numbers[i * i] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
            for (int j = (int) Math.sqrt(i); j > 0; j--) {
                numbers[i] = Math.min(numbers[i], numbers[i - j * j] + 1);
            }
        }
        System.out.println(numbers[N]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1/1-3/3
2/4-8/5
3/9-15/7
4/16-24/9
5/25-35/11
---
반례 41 - 항상 가장 가까운 값으로 줄이면 틀림
 */