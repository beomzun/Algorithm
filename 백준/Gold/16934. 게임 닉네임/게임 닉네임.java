import java.util.*;
import java.io.*;
class Solution {
    Trie trie = new Trie();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> nameCounts = new HashMap<>();
        StringBuilder nickNames = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Trie now = trie;
            boolean findName = false;
            for (int j = 0; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';
                if (now.arr[idx] == null) {
                    now.arr[idx] = new Trie();
                    if (!findName) {
                        findName = true;
                        String nickName = s.substring(0, j + 1);
                        nickNames.append(nickName).append("\n");
                        nameCounts.put(s, nameCounts.getOrDefault(nickName, 0) + 1);
                    }
                }
                now = now.arr[idx];
            }
            if (!findName) {
                int count = nameCounts.getOrDefault(s, 0);
                nameCounts.put(s, count + 1);
                if (count == 0) {
                    nickNames.append(s).append("\n");
                    continue;
                }
                count++;
                nickNames.append(s).append(count).append("\n");
            }
        }

        System.out.println(nickNames);
    }
}
class Trie {
    Trie[] arr = new Trie[26];
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
