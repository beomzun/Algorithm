import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("Z", 1);
        int count=2;

        int[][] capacity = new int[N][N];
        int[][] flow = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (!map.containsKey(s)) {
                map.put(s, count++);
            }
            String e = st.nextToken();
            if (!map.containsKey(e)) {
                map.put(e, count++);
            }
            int w = Integer.parseInt(st.nextToken());
            capacity[map.get(s)][map.get(e)] += w;
            capacity[map.get(e)][map.get(s)] += w;
        }

        int answer = 0;
        int[] parent = new int[N];
        Queue<Integer> q;
        while(true) {
            Arrays.fill(parent, -1);
            q = new ArrayDeque<>();
            parent[0] = 0;
            q.add(0);
            //새로운 경로로 닿을때까지
            while (!q.isEmpty() && parent[1] == -1) {
                int now = q.remove();
                for(int i=0;i<N;i++) {
                    if (parent[i] == -1 && capacity[now][i] - flow[now][i] > 0) {
                        q.add(i);
                        parent[i] = now;
                    }
                }
            }

            //남은 경로를 모두 돌았는데도 새로운 경로를 찾지못하면 그만
            if (parent[1] == -1) {
                break;
            }

            //현재 경로로 보낼수있는 최대량
            int maxW = 700_000;
            for (int i = 1; i != 0; i = parent[i]) {
                maxW = Math.min(maxW, capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            //보내기
            for (int i = 1; i != 0; i = parent[i]) {
                flow[parent[i]][i] += maxW;
                flow[i][parent[i]] -= maxW;
            }
            answer += maxW;
        }

        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
직렬파이프 최소값 / 병렬파이트 병합
파이프 집합에서 가능한 최대유량 출력. A-Z
다음이 없으면 사라짐.
- 자신과 연결된 파이프가 하나인경우 해당 파이프의 결과와 합친 뒤 자신으로 업데이트
- 자신과 연결된 파이프가 여러개인 경우 각 파이프들의 최종값을 모두 더해 자신으로 업데이트
- 연결된게 z인경우 연쇄정지.
- bfs로 훑기
---
파이프 중복 가능
사이클 방지.
---
포드-폴커슨 알고리즘 : 전체 용량, 현재 유량, 잔여 용량 개념으로 해결
반대경로는 왜 관리해야하는가? bfs로 경로를 탐색하는데 좋지않은 경로를 탐색한경우, 잔여용량 식을 사용해서 좋지않은경로를 사용하는 유량을 감소.
 */