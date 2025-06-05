import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});
        }

        int[] dis = new int[N+1];
        dis[s] = 1_000_000;
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        q.add(new int[]{s, 1_000_000});
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int island = now[0];
            int weigh = now[1];
            for(int[] neigh : graph[island]) {
                int nextW = Math.min(weigh, neigh[1]);
                if (dis[neigh[0]] < nextW) {
                    dis[neigh[0]] = nextW;
                    q.add(new int[]{neigh[0], nextW});
                }
            }
        }

        System.out.println(dis[e]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
집 개수, 다리 개수 \ 숭이위치, 혜빈위치 \ 다리정보: 집, 집, 무게
숭이->혜빈까지 최대한의 금뺴뺴로 개수. 숭이 몸무게 고려X
가중치 큰놈 구하기
 */