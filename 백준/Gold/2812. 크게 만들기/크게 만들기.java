import java.util.*;
import java.io.*;
class Solution {
    String base;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        base = br.readLine();
        Deque<Integer> d = new ArrayDeque<>();
        d.add(getInt(0));
        int removeCount=0;
        for (int i = 1; i < N; i++) {
            int val = getInt(i);
            while (removeCount < K && !d.isEmpty() && d.peekLast() < val) {
                d.removeLast();
                removeCount++;
            }
            d.add(val);
        }
        while(removeCount<K) {
            d.removeLast();
            removeCount++;
        }

        StringBuilder sb = new StringBuilder();
        while(!d.isEmpty()) {
            sb.append(d.remove());
        }

        System.out.println(sb);
    }

    public int getInt(int i) {
        return Character.getNumericValue(base.charAt(i));
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
덱으로 나보다 큰놈이면 뒤에붙고, 작은놈이면 제외. 제외가능수가 K
---
반례 : K보다 적게 삭제할수도 있기에 전체수 적용 후 마지막에 대응로직추가
 */