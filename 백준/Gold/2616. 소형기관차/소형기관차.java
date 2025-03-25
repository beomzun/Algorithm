import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[3][N+1];
        for(int i=1;i<=N;i++) {
            arr[0][i] += arr[0][i - 1] + Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=N;i>=K+1;i--) {
            arr[0][i] -= arr[0][i-K];
        }

        int max = 0;
        for(int i=1;i<=K-1;i++) {
            max = Math.max(max, arr[0][i]);
        }
        for(int i=K*2;i<=N-K;i++) {
            max = Math.max(max,arr[0][i-K]);
            arr[1][i] = arr[0][i] + max;
        }

        max=0;
        int answer = 0;
        for(int i=K*2;i<=K*2-1;i++) {
            max = Math.max(max, arr[1][i]);
        }
        for(int i=3*K;i<=N;i++) {
            max = Math.max(max, arr[1][i-K]);
            arr[2][i] = arr[0][i] + max;
            answer = Math.max(answer, arr[2][i]);
        }

        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
3*K < N
3대의 소형기관차로 운송할수있는 최대 사람수.
고르는거말고 버리기..? 17개중에 4개씩 => 4덩이 3개 고르기 / 5개 버리기
최대 NC3 = N^3

1단계 : 인덱스 K부터 누적합으로 진행
2단계 : 인덱스 2K-1부터 진행(두번째 덩어리 선택이니까) -> K보다 작은 인덱스들 중에 max값 선택.
3단계 : 인덱스 3K-1부터 진행
 */