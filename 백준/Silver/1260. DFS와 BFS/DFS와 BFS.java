import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] edge;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());   //정점 개수
        int e = Integer.parseInt(st.nextToken());   //간선 개수
        int s = Integer.parseInt(st.nextToken());   //시작 정점

        edge = new ArrayList[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x].add(y);
            edge[y].add(x);
        }

        for (int i = 1; i <= v; i++) {
            Collections.sort(edge[i]);
        }

        dfs(s);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(s);

        br.close();
    }

    public static void dfs(int s) {
        System.out.print(s + " ");
        visited[s] = true;
        for (int i : edge[s]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i : edge[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
