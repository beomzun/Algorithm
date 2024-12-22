import java.util.*;
import java.io.*;
class Solution {
    int[] parents;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] points = new int[N + 1][2];
        Queue<Edge> q = new PriorityQueue<>((e1, e2) -> {
            if (e1.dis < e2.dis) {
                return -1;
            } else if (e1.dis > e2.dis) {
                return 1;
            }
            return 0;
        });
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i][0] = x;
            points[i][1] = y;

            for (int j = i - 1; j > 0; j--) {
                double dis = Math.sqrt(Math.pow(y - points[j][1], 2) + Math.pow(x - points[j][0], 2));
                q.add(new Edge(j, i, dis));
            }
        }

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        double cost = 0;
        while(!q.isEmpty()) {
            Edge e = q.remove();
            if (union(parents[e.start], parents[e.to])) {
                cost += e.dis;
            }
        }

        System.out.printf("%.2f%n", cost);
    }

    public int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return find(parents[a]);
    }
    public boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
        return true;
    }
}
class Edge {
    int start;
    int to;
    double dis;
    Edge(int start, int to, double dis) {
        this.start = start;
        this.to = to;
        this.dis = dis;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}