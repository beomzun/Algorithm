import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> lines = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines.add(new int[]{start, end});
        }
        lines.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int length = 0;
        int start = lines.get(0)[0];
        int end = lines.get(0)[1];
        for (int i = 1; i < N; i++) {
            int[] line = lines.get(i);
            if (line[0] > end) {
                length += end - start;
                start = line[0];
            }
            end = Math.max(end, line[1]);
        }
        length += end - start;

        System.out.println(length);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
