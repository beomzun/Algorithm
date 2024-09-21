import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] trust = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            trust[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            trust[B].add(A);
        }

        int max = 0;
        int[] result = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            Arrays.fill(visit, false);
            visit[i] = true;

            int count = 1;
            while(!q.isEmpty()) {
                int now = q.remove();
                for (int val : trust[now]) {
                    if (!visit[val]) {
                        q.add(val);
                        visit[val] = true;
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
            result[i] = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
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
b에 a를 추가하여 bfs
 */