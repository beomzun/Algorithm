import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,d});
            graph[b].add(new int[]{a,d});
        }

        int INF = 10_001;
        int[] dis = new int[N+1];
        Arrays.fill(dis, INF);
        dis[1] = 0;

        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
        for(int[] e : graph[1]) {
            q.add(new int[]{e[0], e[1], 1});
        }

        while(!q.isEmpty()) {
            int[] now = q.remove();
            int next = now[0];
            if(dis[next]!=INF) {
                continue;
            }
            sb.append(now[0]).append(" ").append(now[2]).append("\n");

            int d = now[1];
            dis[next] = d;

            for(int[] e : graph[next]) {
                if(dis[e[0]]!=INF) {
                    continue;
                }
                q.add(new int[]{e[0], d+e[1], next});
            }
        }
        
        System.out.println(N-1);
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
N개의 컴퓨터로 이루어진 네트워크 존재
해킹이 발생해서 네트워크 재구성할거임. 기존 회선은 그대로 존재.
1) 최소 회선만 사용해서 네트워크 구성하기
2) 슈퍼컴퓨터가 다른 컴퓨터들과 통신하는 최소 시간이, 원래 네트워크에서의 시간보다 커져서는 안됨
---
최소 회선에서, 시간 유지하거나 감소. 시간 최소가 아님.
MST
 */