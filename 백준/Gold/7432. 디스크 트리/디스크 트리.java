import java.util.*;
import java.io.*;
class Solution {
    Trie trie = new Trie();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Trie now = trie;
            String s = br.readLine();
            String[] words = s.split("\\\\");
            for (String dir : words) {
                if (!now.map.containsKey(dir)) {
                    now.map.put(dir, new Trie());
                }
                now = now.map.get(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : trie.map.keySet()) {
            print(sb, trie.map,0, dir);
        }
        System.out.println(sb);

    }

    public void print(StringBuilder sb, Map<String, Trie> map , int depth, String key) {
        String space = " ".repeat(depth);
        sb.append(space).append(key).append("\n");
        for(String dir : map.get(key).map.keySet()) {
            print(sb, map.get(key).map, depth + 1, dir);
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
