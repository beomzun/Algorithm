import java.util.*;
import java.io.*;
class Solution {
    Trie trie = new Trie();
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Trie now = trie;
            for (int j = 0; j < K; j++) {
                String prey = st.nextToken();
                if (!now.map.containsKey(prey)) {
                    now.map.put(prey, new Trie());
                }
                now = now.map.get(prey);
            }
        }

        Trie now = trie;
        for(String prey : now.map.keySet()) {
            print(0, now.map, prey);
        }
        System.out.println(sb);
    }
    public void print(int depth, Map<String, Trie> map, String prey) {
        String space = "--".repeat(depth);
        sb.append(space).append(prey).append("\n");
        for (String nPrey : map.get(prey).map.keySet()) {
            print(depth + 1, map.get(prey).map, nPrey);
        }
    }
}
class Trie {
    Map<String, Trie> map = new TreeMap<>();
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
