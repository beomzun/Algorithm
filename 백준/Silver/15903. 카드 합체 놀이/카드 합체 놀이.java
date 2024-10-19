import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> cards = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long a = cards.remove();
            long b = cards.remove();
            cards.add(a+b);
            cards.add(a+b);
        }

        long sum = 0;
        while(!cards.isEmpty()) {
            sum += cards.remove();
        }
        System.out.println(sum);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
