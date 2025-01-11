import java.util.*;
import java.io.*;
class Solution {
    Trie trie = new Trie();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            Trie now = trie;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int idx = c - 'a';
                if (now.arr[idx] == null) {
                    now.arr[idx] = new Trie();
                }
                now = now.arr[idx];
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (isExist(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
    public boolean isExist(String s) {
        Trie now = trie;
        for (int j = 0; j < s.length(); j++) {
            int idx = s.charAt(j) - 'a';
            if (now.arr[idx] == null) {
                return false;
            }
            now = now.arr[idx];
        }
        return true;
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
