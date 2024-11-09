import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] city = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
            sum += city[i];
        }
        Arrays.sort(city);

        int total = Integer.parseInt(br.readLine());
        if (sum <= total) {
            System.out.println(city[N - 1]);
            return;
        }

        int min = total / N;
        int max = city[N - 1] + 1;
        while (min < max) {
            int now = (min + max) / 2;
            int tmpSum = 0;
            for (int req : city) {
                tmpSum += Math.min(req, now);
            }
            if (tmpSum > total) {
                max = now;
            } else {
                min = now + 1;
            }
        }

        System.out.println(min - 1);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
