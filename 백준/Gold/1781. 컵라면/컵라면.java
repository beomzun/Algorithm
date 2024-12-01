import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]>[] problems = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            problems[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            problems[deadLine].add(new int[]{deadLine, reward});
        }

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = N; i >= 1; i--) {
            for (int[] problem : problems[i]) {
                pq.add(problem[1]);
            }
            if(pq.isEmpty()) {
               continue;
            }
            result += pq.remove();
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
첫 방식 : Set 에 1~N까지의 일수를 저장. 과제에 대해 보상 내림차순으로 정렬 후 모든 과제에 대해 해당 과제의 마감기한까지의 남은 날짜가 있는지 set에서 탐색 후 존재 시 보상 추가.
새로운 방식 : 모든 과제에 대해 마감기한에 따른 List에 저장. N인 경우 N번째 리스트에 과제 삽입. N부터 1까지 각 마감기한의 과제를 우선순위 큐에 삽입하고, 전체 우선순위 큐에서 하나만 뽑아서 보상 추가
-> N번째에 넣을 녀석, N과 N-1인 애들중에 N-1에 풀 녀석... 3과 2중에 2에 풀 녀석..

시간복잡도 차이 왜 나지?
NlogN과 NlogM (M은 각 List에 속한 과제 수)
 */