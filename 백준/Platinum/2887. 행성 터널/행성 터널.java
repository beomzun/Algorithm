import java.util.*;
import java.io.*;
class Solution {
    int[] parents;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        ArrayList<int[]> X = new ArrayList<>();
        ArrayList<int[]> Y = new ArrayList<>();
        ArrayList<int[]> Z = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            X.add(new int[]{x, i});
            Y.add(new int[]{y, i});
            Z.add(new int[]{z, i});
        }
        X.sort((o1, o2) -> o1[0] - o2[0]);
        Y.sort((o1, o2) -> o1[0] - o2[0]);
        Z.sort((o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        for (int i = 0; i < N - 1; i++) {
            pq.add(new int[]{X.get(i + 1)[0] - X.get(i)[0], X.get(i + 1)[1], X.get(i)[1]});
            pq.add(new int[]{Y.get(i + 1)[0] - Y.get(i)[0], Y.get(i + 1)[1], Y.get(i)[1]});
            pq.add(new int[]{Z.get(i + 1)[0] - Z.get(i)[0], Z.get(i + 1)[1], Z.get(i)[1]});
        }

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        int lineCount = 0;
        long result = 0L;
        while (lineCount != N - 1) {
            int[] now = pq.remove();
            if (union(now[1], now[2])) {
                result += now[0];
                lineCount++;
            }
        }

        System.out.println(result);
    }

    public int find(int now) {
        if (now == parents[now]) {
            return now;
        }
        return find(parents[now]);
    }

    public boolean union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA == pB) {
            return false;
        }

        if (pA < pB) {
            parents[pB] = pA;
        } else {
            parents[pA] = pB;
        }
        return true;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
