import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        boolean[] visit = new boolean[N+1];
        int[] cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        visit[start]=true;
        cost[start]=1_000_000_001;
        int next = start;
        while(next!=-1) {
            int max=cost[next];
            for(Edge e : graph[next]) {
                if(visit[e.num]) {
                    continue;
                }
                cost[e.num] = Math.max(cost[e.num], Math.min(max, e.dis));
            }

            next = -1;
            max = 0;
            for(int i=1;i<=N;i++) {
                if(visit[i]) {
                    continue;
                }
                if(cost[i] > max) {
                    max = cost[i];
                    next = i;
                }
            }
            if(next!=-1) {
                visit[next] = true;
            }
        }

        System.out.println(cost[end]);
    }
}
class Edge {
    int num;
    int dis;
    Edge(int num, int dis) {
        this.num=num;
        this.dis=dis;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N개의 섬 중 일부섬은 M개의 다리로 연결되어있음. 각 다리의 중량제한은 다름.
두 섬을 입력받았을 때, 수송할수있는 최대무게
 */