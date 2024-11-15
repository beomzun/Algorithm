import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0L;
        int start = -1;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            if (map.containsKey(val)) {
                int idx = map.get(val);
                start = Math.max(idx, start);
                count += (i - start);
                map.replace(val, i);
                continue;
            }
            map.put(val, i);
            count += (i - start);
        }

        System.out.println(count);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
꼭 연속해야하나? 의 반례
5
1 2 2 2 1
---
1 2 3 1 2 5 1
1 2 3 3 3 4 3
 */