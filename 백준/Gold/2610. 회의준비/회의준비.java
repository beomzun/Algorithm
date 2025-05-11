import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dis = new int[N+1][N+1];
        int INF = 10_000_000;

        for(int i=1;i<=N;i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dis[a][b] = 1;
            dis[b][a] = 1;
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k]+dis[k][j]);
                }
            }
        }

        boolean[] visit = new boolean[N+1];
        ArrayList<Integer> list = new ArrayList<>();
        //모든 노드 탐색
        for(int i=1;i<=N;i++) {
            //이미 다른 위원회에 속했다면 패스
            if(visit[i]) {
                continue;
            }
            //해당 위원회 탐색
            visit[i] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            int min = Integer.MAX_VALUE;
            int minNum = -1;
            while(!q.isEmpty()) {
                //해당 위원이 대표일 경우
                int now = q.remove();
                int max = 0;
                for(int j=1;j<=N;j++) {
                    if(dis[now][j]!=INF) {
                        max = Math.max(max, dis[now][j]);
                        if(!visit[j]) {
                            visit[j] = true;
                            q.add(j);
                        }
                    }
                }
                if(max<min) {
                    min = max;
                    minNum = now;
                }
            }
            list.add(minNum);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int num : list) {
            sb.append(num).append("\n");
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
서로 알고있는 사람은 같은 위원회.
위원회의 수는 최대로.
위원회 구성 후 위원회마다 대표를 선출해야함.
대표만 발언할수있기에 다른 위원들은 대표에게 자신의 의견을 전달해야함.
모든 의원들이 대표로 의견을 모으는 최소시간을 구하시오.
---
위원회 그룹 구성.
각 그룹에서 대표로 적합한 인원찾기 - 플로이드워셜로 전달시간 찾기.
전달시간의 최대값이 최소가 되는 대표 선정하기!!! 한 의원이 대표일때의 합산 전달시간이 최소가 아님ㅜㅜ
대표번호 오름차순 출력
 */