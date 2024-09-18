import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] ar;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        visited = new boolean[num + 1];

        ar = new ArrayList[num + 1];
        for (int i = 1; i <= num; i++) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 1; i <= line; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ar[x].add(y);
            ar[y].add(x);
        }
        bfs(1);
        System.out.println(count);
    }
    public static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : ar[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        count++;
        for (int i = 1; i < ar.length; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }
}