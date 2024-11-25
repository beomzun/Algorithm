import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //보석 개수
        int K = Integer.parseInt(st.nextToken());   //가방 개수
        PriorityQueue<int[]> jewels = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());   //보석 무게
            int V = Integer.parseInt(st.nextToken());   //보석 가격
            jewels.add(new int[]{M, V});
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bags[i] = C;
        }
        Arrays.sort(bags);

        long result = 0L;
        PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
        for (int bag : bags) {
            while (!jewels.isEmpty() && bag >= jewels.peek()[0]) {
                values.add(jewels.remove()[1]);
            }
            if (values.isEmpty()) {
                continue;
            }
            result += values.remove();
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
무게랑 가격을 어떻게 배분할것인가. 비싼놈부터 자신의 무게보다 큰거중에 가장 작은 가방에 배치.
가격높은순/무거운순으로 정렬. 가방은 무게순으로 정렬.
---
가방 정렬 누락
---
시간복잡도 초과. 찾았을때 일차선으로 이동하지 말고 이분탐색 꾸역꾸역 사용하자.
범위 올리기 : 가방이 작거나 || 같은데 사용했거나
범위 내리기 : 가방이 큰데 사용안했을때 || 같은데 사용안했거나
여기서 가방이 큰데 사용했다면 양쪽 나눠서 왼쪽에 없으면 자신보다 큰쪽 탐색
---
이분탐색으로 자신과 크거나 같은 가방의 첫 인덱스 탐색 -> 여기서 이분탐색으로 사용안한녀석 찾기.
---
가방 오름차순 정렬 + 보석 무게오름차순/가격내림차순 우선순위 큐. 각 가방에 대해 자신 이하의 무게인 보석은 가격 우선순위 큐 삽입 후 하나씩 빼기
 */