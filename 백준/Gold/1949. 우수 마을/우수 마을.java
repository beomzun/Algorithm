import java.util.*;
import java.io.*;
class Solution {
    int[] people;
    ArrayList<Integer>[] graph;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        graph = new ArrayList[N+1];
        dp = new int[N+1][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            people[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1,0);
        int max = Math.max(dp[1][0], dp[1][2]);

        System.out.println(max);
    }

    public void dfs(int now, int parent) {
        dp[now][0] = people[now];
        dp[now][1] = 0;
        boolean childExist = false;
        int tmp=0;
        int minDif = -10000;

        for(int neigh : graph[now]) {
            if (neigh == parent) {
                continue;
            }
            dfs(neigh, now);

            //지금 방문인 경우
            dp[now][0] += dp[neigh][1];

            //지금 선택 안한경우 + 이전엔 선택한 경우 => 해도되고 안해도됨.
            dp[now][1] += Math.max(dp[neigh][0], dp[neigh][2]);

            //지금 선택 안했고, 이전에도 안한경우
            int check0 = dp[neigh][0];
            int check2 = dp[neigh][2];
            if(check0> check2) {
                tmp += check0;
                childExist = true;
            } else {
                tmp += check2;
                minDif = Math.max(minDif, check0-check2);
            }
        }

        dp[now][2] = childExist ? tmp : tmp + minDif;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N개의 마을 - 트리 구조, N-1개의 길. 대신 양방향임
직접잇는길이 있다면 인접하다.
우수마을 선정조건
1. 우수 마을로 선정된 마을 주민수의 총 합을 최대로
2. 우수 마을끼리는 인접할 수 없음
3. 우수 마을이 아닌 마을은 적어도 하나의 우수마을과 인접해야한다.
---
1부터 선정 시와 비선정 시 dfs.
선정 - 나머지 비선정
비선정 - 나머지 비선정 또는 선정
---
비우수 마을은 이웃 중 최소'하나'의 우수만 이웃하면된다.
 */