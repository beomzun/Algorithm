import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] fib = new int[N + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        int fixCount = Integer.parseInt(br.readLine());
        if (fixCount == 0) {
            System.out.println(fib[N]);
            return;
        }
        int lastSeat = 0;
        int result = 1;
        for (int i = 0; i < fixCount; i++) {
            int fixedSeat = Integer.parseInt(br.readLine());
            result *= fib[fixedSeat - lastSeat - 1];
            lastSeat = fixedSeat;
        }
        result *= fib[N - lastSeat];
        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1 -> 1
2 -> 2
3 -> 3
4 -> 5
5 -> 8
 */