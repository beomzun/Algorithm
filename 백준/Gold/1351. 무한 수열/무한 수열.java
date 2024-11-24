import java.util.*;
import java.io.*;
class Solution {
    Map<Long, Long> values = new HashMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        System.out.println(dfs(N, P, Q));
    }
    public long dfs(long N, int P, int Q) {
        if (N == 0) {
            return 1;
        }
        
        if (!values.containsKey(N / P)) {
            values.put(N / P, dfs(N / P, P, Q));
        }
        long pV = values.get(N / P);

        if (!values.containsKey(N / Q)) {
            values.put(N / Q, dfs(N / Q, P, Q));
        }
        long pQ = values.get(N / Q);
        
        return pV + pQ;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
i/p \ i/q 가 몇개인가?
1_000_000_000_000

7 2 3
7 = 7/2 + 7/3 => 3+2 -> 3/2+3/3 + 2/2+2/3
 */