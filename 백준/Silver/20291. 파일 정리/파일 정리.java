import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++) {
            String[] s = br.readLine().split("\\.");
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");

        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*

 */