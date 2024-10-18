import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> rest = new PriorityQueue<>();
        ArrayList<int[]> classes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes.add(new int[]{start, end});
        }

        classes.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        rest.add(classes.get(0)[1]);
        for (int i = 1; i < N; i++) {
            if (classes.get(i)[0] >= rest.peek()) {
                rest.remove();
            }
            rest.add(classes.get(i)[1]);
        }
        System.out.println(rest.size());
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
