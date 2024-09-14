import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> counts = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (counts.containsKey(val)) {
                counts.replace(val, counts.get(val) + 1);
            } else {
                counts.put(val, 1);
            }
        }

        ArrayList<Integer> sorted = new ArrayList<>(counts.keySet());
        sorted.sort((o1, o2) -> Integer.compare(counts.get(o2), counts.get(o1)));

        StringBuilder sb = new StringBuilder();
        for (int tmp : sorted) {
            for (int i = 0; i < counts.get(tmp); i++) {
                sb.append(tmp).append(" ");
            }
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
수의 빈도, 출현 순서
수, [0]빈도, [1]등장순서
---
2차원 배열 사용 시 메모리 초과
---
Map 두 개 써도 메모리 초과 => 우선순위 큐 문제
 */