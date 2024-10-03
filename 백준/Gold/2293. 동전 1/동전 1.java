import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        int[] counts = new int[K + 1];
        counts[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                counts[j] += counts[j - coins[i]];
            }
        }
        System.out.println(counts[K]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1 : 1 1 1 1 1 1 1 1 1 1
2 : 0 1 1 2 2 3 3 4 4 5
5 : 0 0 0 0 1 1 2 2 3 4

가장 작은수로 1~K까지 만들수 있는 경우의수 설정 0 or 1일 것임. K=4일 때 첫 동전이 3이면 0 0 1 0.
그 다음 동전부터 K까지 경우의 수 갱신. 이 때는 dp의 첫 인덱스부터가 아닌 동전값부터 시작. 그 이전은 변함없기 때문.
이전 동전까지의 경우의 수에, 지금 동전 사용했을 때 이 동전값을 제외한 값을 만들 수 있는 경우의 수만큼 추가
 */