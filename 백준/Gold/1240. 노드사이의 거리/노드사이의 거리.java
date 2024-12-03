import java.util.*;
import java.io.*;
class Solution {
    Map<Integer, Integer>[] tree;
    boolean[] visit;
    Stack<Integer> stack;
    int result = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new Map[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new HashMap<>();
        }
        // 노드번호1,2,거리
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            tree[a].put(b, dis);
            tree[b].put(a, dis);
        }
        // 궁금한 노드들
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visit = new boolean[N + 1];
            stack = new Stack<>();
            visit[start] = true;
            stack.add(start);
            result = 0;
            dfs(end);
            bw.write(result + "\n");
        }
        bw.flush();
    }

    public boolean dfs(int end) {
        int now = stack.peek();
        for (int key : tree[now].keySet()) {
            if (key == end) {
                result += tree[now].get(key);
                return true;
            }
            if (visit[key]) {
                continue;
            }
            visit[key] = true;
            stack.add(key);
            if (dfs(end)) {
                result += tree[now].get(key);
                return true;
            }
            stack.pop();
        }

        return false;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}