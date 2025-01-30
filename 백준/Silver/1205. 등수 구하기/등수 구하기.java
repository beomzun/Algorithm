import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] rank = new int[P];
        Arrays.fill(rank, -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        if (rank[P - 1] >= score) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < P; i++) {
            if (rank[i] <= score) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
