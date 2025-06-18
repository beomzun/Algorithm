import java.util.*;
import java.io.*;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visit;
    boolean[] circuit;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visit = new boolean[N+1];
        circuit = new boolean[N+1];
        visit[1] = true;
        dfs(1,0);

        Arrays.fill(visit, false);
        int[] dis = new int[N+1];
        for(int i=1;i<=N;i++) {
            if(circuit[i]) {
                visit[i] = true;
                dis[i] = 0;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                while(!q.isEmpty()) {
                    int now = q.remove();
                    for(int next : graph[now]) {
                        if(visit[next]) {
                            continue;
                        }
                        visit[next] = true;
                        if(circuit[next]) {
                            dis[next] = 0;
                        } else {
                            dis[next] = dis[now]+1;
                        }
                        q.add(next);
                    }
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(dis[i]).append(" ");
        }
        System.out.println(sb);
    }

    boolean check = false;
    int point = -1;
    public boolean dfs(int num, int parent) {
        for(int next : graph[num]) {
            if(next==parent) {
                continue;
            }
            if(visit[next]) {
                check = true;
                point = next;
                circuit[num] = true;
                return true;
            }
            visit[next] = true;
            if(dfs(next, num)) {
                circuit[num] = true;
                if (num == point) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
한 점에서 시작해서 dfs 진행. 진행하다 방문한 점 발견시 순환선체크하고 복귀
 */