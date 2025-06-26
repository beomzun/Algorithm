import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());   //테케 번호
            int M = Integer.parseInt(st.nextToken());   //노드 수
            int P = Integer.parseInt(st.nextToken());   //간선 수
            ArrayList<Integer>[] graph = new ArrayList[M + 1];
            for(int i=1;i<=M;i++) {
                graph[i] = new ArrayList<>();
            }

            int[][] river = new int[3][M + 1];  //자식수, 최대i, 픽스한 순서
            for(int i=0;i<P;i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                graph[A].add(B);
                river[0][B]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for(int i=1;i<=M;i++) {
                if(river[0][i]==0) {
                    q.add(i);
                    river[2][i] = 1;
                }
            }

            while(!q.isEmpty()) {
                int now = q.remove();
                if (graph[now].isEmpty()) {
                    sb.append(K).append(" ").append(river[2][now]).append("\n");
                    break;
                }
                for(int next : graph[now]) {
                    river[0][next]--;
                    if(river[1][next]==river[2][now]) {
                        river[2][next] = river[1][next] + 1;
                    } else if(river[1][next] < river[2][now]) {
                        river[1][next] = river[2][now];
                        river[2][next] = river[1][next];
                    }

                    if (river[0][next] == 0) {
                        q.add(next);
                    }
                }
            }
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
노드는 강이 시작하는곳, 합쳐지거나 나눠지는곳, 바다와 만나는 곳
하천계의 순서는 바다와 만나는 노드의 순서와 같다
나에게 들어오는 모든 강 중에서 Strahler 순서가 i인 강이 1개이면 순서는 i, 2개 이상이면 순서는 i+1이다.
---
위상정렬
A->B 일 때 나를 포인트하는 자식이 없으면 순서 1
위상정렬 과정에서 그래프, 자식수, 최대 i 필요. 2개 이상만 되면 되니까 개수는 상관없음.
자식수 0이 되면 흐르기시작.
 */