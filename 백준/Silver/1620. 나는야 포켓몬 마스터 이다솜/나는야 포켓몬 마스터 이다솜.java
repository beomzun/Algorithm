import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] names = new String[N + 1];
        Map<String, Integer> poketmon = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            names[i] = name;
            poketmon.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            char c = problem.charAt(0);
            if (c >= '1' && c <= '9') {
                bw.write(names[Integer.parseInt(problem)] + "\n");
            } else {
                bw.write(poketmon.get(problem) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
