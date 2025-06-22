import java.util.*;
import java.io.*;
class Solution {
    boolean[] isWolf;
    int[] how;
    int[] parent;
    int[] childCounts;
    long[] sum;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isWolf = new boolean[N + 1];  //늑대섬여부
        how = new int[N + 1]; //마리 수
        parent = new int[N + 1];
        childCounts = new int[N + 1];
        sum = new long[N + 1];

        for(int i=2;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("W")) {
                isWolf[i] = true;
            }
            how[i] = Integer.parseInt(st.nextToken());
            parent[i] = Integer.parseInt(st.nextToken());
            childCounts[parent[i]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=2;i<=N;i++) {
            if(childCounts[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.remove();
            if(now==1) {
                System.out.println(sum[1]);
                return;
            }
            //내가 늑대면 나한테 쌓인애들과 연산
            if(isWolf[now]) {
                if(how[now] < sum[now]) {
                    sum[parent[now]] += (sum[now] - how[now]);
                }
            } else {    //양이면 부모한테 토스
                sum[parent[now]] += (sum[now] + how[now]);
            }

            if(--childCounts[parent[now]]==0) {
                q.add(parent[now]);
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
1번섬에 구명보트, 나머지 섬에 늑대/양
각 섬에서 1번섬으로의 경로는 유일하다.
i번 섬에는 pi번 섬으로 가는 다리가 있다
늑대들은 섬으로 들어오는 양들을 잡아먹음. 늑대한마리는 양한마리만 잡음
---
섬개수 \ 입력 순서가 2번부터인 섬 번호이
양 늑대 여부 / 해당 개체 수 / 몇 번 섬으로 갈 수 있는지
구할수있는 양의 수
---
리프 노드부터 출발해서 한번에 훑도록 -> 섬 모양 이상하면(--..---< 이렇게생기면) 시간초과, 그리고 중복할수도
=> 방문표시랑 메모이제이션 사용
---
** 늑대는 일생동안 한마리만 먹음. 들어올떄마다가 아님.
7
W 10 1
W 40 2
W 10 2
S 100 3
S 50 3
S 20 4
---
N to 1 이 아니라 1 to N으로.
전역 스택으로 관리하되 리프가 늑대인 경우 다음 dfs에 사이드 이펙트 발생.
=> 리프가 양일때까지만 가고, 스택 데이터로 비교. 어디서 넣었는지 필요함
---
위상정렬...
 */