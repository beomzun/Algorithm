import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }

        bw.write(map.getOrDefault(target, 0) + "");
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
