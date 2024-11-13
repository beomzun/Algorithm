import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 2) {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] notPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (notPrime[i]) {
                continue;
            }
            primes.add(i);
            for (int j = i * 2; j <= N; j += i) {
                notPrime[j] = true;
            }
        }
        int left = 0;
        int right = 0;
        int sum = primes.get(0);
        int count = 0;
        while (right < primes.size()) {
            if (sum <= N) {
                if (sum == N) {
                    count++;
                }
                right++;
                if (right == primes.size()) {
                    break;
                }
                sum += primes.get(right);
            } else {
                sum -= primes.get(left++);
            }
        }
        System.out.println(count);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();

    }
}
