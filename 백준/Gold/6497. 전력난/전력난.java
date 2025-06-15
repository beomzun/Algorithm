import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(M!=0) {
            ArrayList<int[]>[] graph = new ArrayList[M];
            for(int i=0;i<M;i++) {
                graph[i] = new ArrayList<>();
            }
            int total = 0;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                total += w;
                graph[a].add(new int[]{b, w});
                graph[b].add(new int[]{a, w});
            }

            int best = 0;
            boolean[] visit = new boolean[M];
            visit[0] = true;
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            q.addAll(graph[0]);
            while(!q.isEmpty()) {
                int[] now = q.remove();
                if(visit[now[0]]) {
                    continue;
                }
                visit[now[0]] = true;
                best += now[1];
                for(int[] edge : graph[now[0]]) {
                    if(visit[edge[0]]) {
                        continue;
                    }
                    q.add(edge);
                }
            }

            sb.append(total - best).append("\n");
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
        }

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
첫 줄에 입력 두개
N개줄에 길정보 -> 그다음에 00이면 종료
0번집부터 시작
---
절약할수있는최대비용 => 전체 합한거에서 MST 빼기
 */