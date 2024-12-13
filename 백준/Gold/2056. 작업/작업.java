import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] parents = new ArrayList[N+1];
        int[] seconds = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            seconds[i] = time;

            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                parents[i] = new ArrayList<>();
            }
            int last = 0;
            for (int j = 0; j < num; j++) {
                int parent = Integer.parseInt(st.nextToken());
                last = Math.max(last, seconds[parent]);
            }
            seconds[i] += last;

            max = Math.max(max, seconds[i]);
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
