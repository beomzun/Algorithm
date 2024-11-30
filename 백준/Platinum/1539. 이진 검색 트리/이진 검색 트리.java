import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int root = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(root, 1);
        long result = 1L;
        for (int i = 1; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            Integer low = tree.lowerKey(val);
            Integer high = tree.higherKey(val);
            int height;
            if (low != null && high != null) {
                height = Math.max(tree.get(high), tree.get(low)) + 1;
            } else if (low == null) {
                height = tree.get(high) + 1;
            } else {
                height = tree.get(low) + 1;
            }
            result += height;
            tree.put(val, height);
        }

        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
직접 시뮬레이션 최악 n^2
---
큰놈중작은놈 \ 작은놈중큰놈 중 큰 수+1
 */