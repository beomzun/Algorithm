import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int totalSum = 0;
    static int[] totalRow;
    static int[] totalCol;

    public void solution() throws IOException {
        input();
        team(0, 0, totalSum);
        System.out.println(min);
    }

    public void team(int now, int num, int sum) {
        if (num == N / 2) {
            min = Math.min(min, Math.abs(sum));
            if (min == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        if (now == N) {
            return;
        }

        team(now + 1, num + 1, sum - totalRow[now] - totalCol[now]);
        team(now + 1, num, sum);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        totalRow = new int[N];
        totalCol = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                totalSum += val;
                totalRow[i] += val;
                totalCol[j] += val;
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
경우의 수 : NC2 / 2
시간복잡도 : (N/2 -1)! * 2
- 4 3 2
1 - 3 5
6 3 - 2
4 5 4 -
백트래킹으로 팀 구분 -> 팀 완성 시 점수 계산
---
시간초과
- 팀 선택 시 재귀 호출시에 다음 인덱스부터 보도록 수정
---
미친 아이디어
- 입력받을 때 전체 합 계산. 백트래킹으로 팀 나눠가며 전체합에서 고른수의 행, 열에 해당하는 점수 차감 => 무슨 느낌이냐면 전체합(1,2,3,4) 에서 행 차감(1,2) - 열 차감(1,2)
=> 그러면 (3,4) - (1,2) 로 차이 구할 수 있음
 */