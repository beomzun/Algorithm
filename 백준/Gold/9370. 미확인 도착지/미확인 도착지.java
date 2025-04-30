import java.util.*;
import java.io.*;
class Solution {
    ArrayList<int[]>[] graph;
    int INF = 50_000_000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //노드 수
            int M = Integer.parseInt(st.nextToken());   //도로 수
            int TG = Integer.parseInt(st.nextToken());  //목적지 후보수
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());   //출발 노드번호
            int G = Integer.parseInt(st.nextToken());   //냄새 노드1 번호
            int H = Integer.parseInt(st.nextToken());   //냄새 노드2 번호
            int ghDis = 0;

            graph = new ArrayList[N+1];
            for(int i=1;i<=N;i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());   //연결 노드1 번호
                int b = Integer.parseInt(st.nextToken());   //연결 노드2 번호
                int d = Integer.parseInt(st.nextToken());   //도로 길이
                graph[a].add(new int[]{b,d});
                graph[b].add(new int[]{a,d});
                if(a==G && b==H || a==H && b==G) {
                    ghDis = d;
                }
            }

            int[] targets = new int[TG];
            for(int i=0;i<TG;i++) {
                targets[i] = Integer.parseInt(br.readLine());
            }

            int[] gDis = new int[N+1];
            calcDis(G,gDis);

            int[] hDis = new int[N+1];
            calcDis(H,hDis);

            int[] sDis = new int[N+1];
            calcDis(S, sDis);

            ArrayList<Integer> answer = new ArrayList<>();
            for(int i=0;i<TG;i++) {
                int target = targets[i];
                int tDis = sDis[target];
                if(tDis == sDis[H]+ghDis+gDis[target] || tDis == sDis[G]+ghDis+hDis[target]) {
                    answer.add(target);
                }
            }
            Collections.sort(answer);

            StringBuilder sb = new StringBuilder();
            for(int val : answer) {
                sb.append(val).append(" ");
            }
            System.out.println(sb);
        }
    }
    public void calcDis(int start, int[] dis) {
        Arrays.fill(dis, INF);
        dis[start] = 0;
        Queue<int[]> q = new PriorityQueue<>((o1,o2)-> {
            return o1[1]-o2[1];
        }); //거리 오름차순
        q.addAll(graph[start]);
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int next = now[0];
            int nowD = now[1];
            if(dis[next]!=INF) {
                continue;
            }
            dis[next] = nowD;
            for(int[] e : graph[next]) {
                if(dis[e[0]]!=INF) {
                    continue;
                }
                q.add(new int[]{e[0], nowD+e[1]});
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
테스트 케이스 T개
n,m,t - 노드 수, 도로 수, 목적지 후보 수
s,g,h - 도둑 출발 노드 번호, g-h는 도둑이 지나간 도로의 노드번호
m개의 줄에는 a,b,d - a,b는 도로에 연결된 노드 번호, d는 거리
t개의 줄에는 목적지 후보 번호들
도둑은 출발지부터 목적지까지 최단 경로로 이동함. g-h 도로를 이동하면서 최단거리인 목적지들 추출.
-> 목적지 후보들 중 불가능한 경우를 제외한 목적지를 공백으로 분리 후 오름차순으로 출력

1. 시작노드-g 거리 측정 \ 시작노드-h 거리 측정
2. h-각 목적지 노드 거리 측정 \ g-각 목적지 노드 거리 측정
1,2 통합. h,g부터 전체 노드 거리 측정
3. 시작부터 각 목적지 노드 거리 측정.
4. 시작-h + h-g + g-목적지 \ 시작-g + g-h + h-목적지 와 3 측정값이 같다면 정답.
 */