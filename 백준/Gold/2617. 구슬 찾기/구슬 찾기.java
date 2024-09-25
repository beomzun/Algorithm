import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] balls = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            balls[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            balls[b].add(a);
        }

        boolean[] visit = new boolean[N + 1];
        int[] called = new int[N + 1];
        int result = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visit, false);
            int count = 0;

            q.add(i);
            while (!q.isEmpty()) {
                int now = q.remove();
                for (int next : balls[now]) {
                    if (visit[next]) {
                        continue;
                    }
                    visit[next] = true;
                    q.add(next);
                    called[next]++;
                    count++;
                }
            }
            if (count > N / 2) {
                result++;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (called[i] > N / 2) {
                result++;
            }
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
/* 자신보다 무거운 것 담기
1 / 2 5 -> 4
2 / 4
3 / 4
4 /
5 /
=> 번호마다 dfs 돌려서 자신보다 무거운 개수 탐색 + 한 번호마다 자신이 불린 횟수 확인
자신보다 무거운 게 일정 수 이상인 경우 + 불린 횟수가 일정 수 이상인 경우
 */