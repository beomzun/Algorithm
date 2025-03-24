import java.util.*;
import java.io.*;
class Solution {
    int N;
    ArrayList<Integer>[] graph;
    boolean[][] neigh;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        neigh = new boolean[N+1][N+1];
        for(int i=1;i<=N;i++) {
            floyd(i);
        }
        
        StringBuilder sb = new StringBuilder();
        int S = Integer.parseInt(br.readLine());
        for(int i=0;i<S;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(neigh[a][b]) {
                sb.append(-1).append("\n");
                continue;
            }
            if(neigh[b][a]) {
                sb.append(1).append("\n");
                continue;
            }
            sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
    
    public void floyd(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];
        q.add(start);
        while(!q.isEmpty()) {
            int now = q.remove();
            for(int child: graph[now]) {
                if(visit[child]) {
                    continue;
                }
                neigh[start][child] = true;
                visit[child]=true;
                q.add(child);
            }
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
사건개수 N, 관계수 K
위로 추론할수있는 관계 정립.
궁금한 사건 수 S -> 순서대로면 -1, 역순이면 1, 모르면 0
위상정렬
---
매번 탐색하면 메모리초과
 */