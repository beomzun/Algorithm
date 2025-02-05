import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lines, (l1, l2) -> l1[0] - l2[0]);

        int[] dp = new int[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(dp, 0, length, lines[i][1]);
            if(pos<0) {
                pos = -(pos+1);
            }
            dp[pos] = lines[i][1];
            if(pos==length) {
                length++;
            }
        }
        System.out.println(N-length);
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
전체 n개 중에 가장 교차점이 많은 전깃줄 제거. 하나 제거할때마다 n제곱
교차 : 1번전봇대가 나보다 큰 경우 -> 2번은 나보다 작아야함. / 1번전봇대가 나보다 작은 경우 -> 2번은 나보다 커야함
---
LIS. A전봇대 위치로 정렬 후 B전봇대에서의 LIS를 찾으면됨. LIS는 n2으로 자기앞의 모든 인덱스를 돌면서 작은 경우 +1 하거나(n^2) length를 이용한 이분탐색으로 진행할수잇다.
binarySearch : 시작~끝-1 중에 키 위치. 없으면 키보다 큰값의 인덱스(0,2에서 1찾을 시 1)의 음수값 -1 리턴. 또는 모두 키보다 작을 경우 끝인덱스 응답.
 */