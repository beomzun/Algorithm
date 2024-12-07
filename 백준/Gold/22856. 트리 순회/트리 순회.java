import java.util.*;
import java.io.*;
class Solution {
    int[][] tree;
    int move = 0;
    int rest;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        rest = N;
        tree = new int[2][N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[0][node] = left;
            tree[1][node] = right;
        }
        start(1);
    }

    public void start(int node) {
        if (tree[0][node] != -1) {
            move++;
            start(tree[0][node]);
        }
        rest--;
        if (rest == 0) {
            System.out.println(move);
            return;
        }
        if (tree[1][node] != -1) {
            move++;
            start(tree[1][node]);
        }
        move++;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
마지막 노드는 중위 순회의 마지막 노드. 마지막으로 방문하는 노드가 아님
 */