import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bytes = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] costs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N * 100 + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N * 100; j++) {
                if (j < costs[i]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i]] + bytes[i]);
            }
        }
        for (int i = 0; i <= N * 100; i++) {
            if (dp[N][i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s= new Solution();
        s.solution();
    }
}
/*
앱 N개 / 필요 바이트 M
활성화 앱이 사용중인 바이트 m
비활성화 비용 c

사용바이트는 크고 비용은 작은거
바이트 큰애들로 채운다음에 비용 낮추기
바이트 내림차순으로 정렬 -> 제거 대상자들 우선순위큐에 삽입. 큐의 우선순위는 비용내림차순, 바이트 오름차순
정렬된 거에서 보는데, 큐의 맨앞과 비교했을때 바이트는 물론 작겠지만,

최소 비활성화 비용 출력
---
2차원dp : j만큼의 비용을 사용했을 때 i번째 앱에서의 최대 메모리
j가 현재 비용보다 클 때 : 현재 비용을 지불하기 전의 메모리에 현재 메모리 추가 vs 현재 메모리를 사용하지 않는 이전 행의 값
중간에 드는 의문 : 적당히 비싸면서 적당히 바이트수도 큰 애는 빼는게 낫나 넣는게 낫나? 라는 고민은 필요없음.
요구사항은 전체를 다봤을때의 최소비용임. 따라서 고민하지 않고 계산을 통해 해당 비용에서의 최대 메모리를 뽑아내고 결론은 마지막 행에서 내리면됨.
 */