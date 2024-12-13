import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] counts = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            counts[child]++;
        }

        PriorityQueue<Integer> solved = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == 0) {
                solved.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!solved.isEmpty()) {
            int now = solved.remove();
            sb.append(now).append(" ");

            for (int child : graph[now]) {
                counts[child]--;
                if (counts[child] == 0) {
                    solved.add(child);
                }
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
dfs 시 풀이순서가 정확하지 않음.
5를 풀면 1,3을 풀 수 있고, 1을 풀면 4를 풀 수 있을 때 dfs의 경우 5 1 4 3으로 귀결됨. 그러나 정답은 5 1 3 4임
 */