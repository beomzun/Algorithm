import java.util.*;
import java.io.*;

class Solution {
    static int[][] gear = new int[5][8];
    static boolean[] visit;
    static int[] left = {0, 0, 6, 6, 6};
    static int[] right = {0, 2, 2, 2};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            visit = new boolean[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate(num, dir);
        }
        System.out.println(score());
    }

    public int score() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i + 1][twelve(i + 1)] == 1) {
                sum += (int)Math.pow(2, i);
            }
        }
        return sum;
    }

    public void rotate(int num, int dir) {
        if (visit[num]) {
            return;
        }
        visit[num] = true;

        if (dir == 1) {
            if (num + 1 <= 4 && gear[num][right[num]]!=gear[num+1][left[num+1]]) {
                rotate(num + 1, -1);
            }
            if (num <= 3) {
                right[num] = over(right[num] - 1);
            }

            if (num - 1 > 0 && gear[num][left[num]] != gear[num - 1][right[num - 1]]) {
                rotate(num - 1, -1);
            }
            if (num >= 2) {
                left[num] = over(left[num] - 1);
            }
        } else {
            if (num + 1 <= 4 && gear[num][right[num]]!=gear[num+1][left[num+1]]) {
                rotate(num + 1, 1);
            }
            if (num <= 3) {
                right[num] = over(right[num] + 1);
            }

            if (num - 1 > 0 && gear[num][left[num]] != gear[num - 1][right[num - 1]]) {
                rotate(num - 1, 1);
            }
            if (num >= 2) {
                left[num] = over(left[num] + 1);
            }
        }
    }

    public int twelve(int num) {
        if (num != 4) {
            int result = right[num] - 2;
            if (result < 0) {
                return result + 8;
            }
            return result;
        }

        int result = left[num] + 2;
        if (result > 7) {
            return result - 8;
        }
        return result;
    }

    public int over(int val) {
        if (val < 0) {
            val=7;
        }
        if (val > 7) {
            val = 0;
        }
        return val;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
입력
첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다.
상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다.
다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고,
첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.

과정
톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.
맞닿은 톱니의 극이 같다면, A가 회전할 때 B는 회전하지 않는다

출력
총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.
1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점

해결
톱니바퀴 상태를 저장하는것을 덱이 먼저 떠올랐으나, 배열로 저장 후 각 톱니 별 좌우 인덱스를 두는 것으로 해결함.

 */