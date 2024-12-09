import java.util.*;
import java.io.*;
class Solution {
    Map<Integer, Integer> parents = new HashMap<>();
    int[][] graph;
    int col = 0;
    ArrayList<Integer>[] rows;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[2][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph[0][now] = left;
            graph[1][now] = right;
            if (left != -1) {
                parents.put(left, now);
            }
            if (right != -1) {
                parents.put(right, now);
            }
        }

        rows = new ArrayList[N + 1];
        int root = findRoot();
        dfs(root,1);
        int row = 1;
        int maxRow = 1;
        int maxLength = 0;
        while (row <= N && rows[row] != null) {
            int length = rows[row].get(rows[row].size() - 1) - rows[row].get(0) + 1;
            if (length > maxLength) {
                maxLength = length;
                maxRow = row;
            }
            row++;
        }

        System.out.println(maxRow + " " + maxLength);
    }

    public int findRoot() {
        int now = 1;
        while (parents.containsKey(now)) {
            now = parents.get(now);
        }
        return now;
    }

    public void dfs(int now, int row) {
        if (graph[0][now] != -1) {
            dfs(graph[0][now], row + 1);
        }

        col++;
        if (rows[row] == null) {
            rows[row] = new ArrayList<>();
        }
        rows[row].add(col);

        if (graph[1][now] != -1) {
            dfs(graph[1][now], row + 1);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
dfs 중위순회
 */