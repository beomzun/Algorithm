import java.util.*;
import java.io.*;

class Solution {
    static int[][] egg;
    static int count = 0;
    static int max = 0;
    static int n;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        egg = new int[2][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            //0행 내구도 / 1행 무게
            egg[0][i] = Integer.parseInt(st.nextToken());
            egg[1][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            dfs(0, i);
        }

        System.out.println(max);
    }

    public void dfs(int depth, int index) {
        int prev = count;

        hit(depth, index);

        //손에 들 계란 탐색
        int next = depth + 1;
        for (; next <= n; next++) {
            //맨 오른쪽일 경우
            if (next == n) {
                max = Math.max(max, count);
                recovery(depth, index, prev);
                return;
            }
            if (egg[0][next] > 0) {
                break;
            }
        }

        //맞을 계란 선택
        for (int i = 0; i <= n; i++) {
            //맞을 계란 없는 경우
            if (i == n) {
                max = Math.max(max, count);
                recovery(depth, index, prev);
                return;
            }

            if (egg[0][i] < 1 || next == i) {
                continue;
            }
            dfs(next, i);
        }
        recovery(depth, index, prev);
    }

    public void hit(int depth, int index) {
        //격파
        egg[0][index] -= egg[1][depth];
        egg[0][depth] -= egg[1][index];
        if (egg[0][index] < 1) {
            count++;
        }
        if (egg[0][depth] < 1) {
            count++;
        }
    }

    public void recovery(int depth, int index, int prev) {
        egg[0][index] += egg[1][depth];
        egg[0][depth] += egg[1][index];
        count = prev;
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
첫째 줄에 계란의 수를 나타내는 N(1 ≤ N ≤ 8)가 주어진다. 그 다음 N개의 줄에는 계란의 내구도와 무게에 대한 정보가 주어진다. i+1번째 줄에는 왼쪽에서 i번째에 위치한 계란의 내구도 Si(1 ≤ Si ≤ 300)와 무게 Wi(1 ≤ Wi ≤ 300)가 한 칸의 빈칸을 사이에 두고 주어진다.

과정
1. 가장 왼쪽의 계란을 든다.
2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다. 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
일렬로 놓인 계란들의 내구도와 무게가 차례대로 주어졌을 때 최대 몇 개의 계란을 깰 수 있는지 알아맞춰보자.

출력
첫째 줄에 인범이가 깰 수 있는 계란의 최대 개수를 출력한다.

해결
브루트포스
---
조건을 벗어났을 경우 리턴 전에 이전결과로 복구하는 과정 빼먹음.
count 를 그대로 둔다던가, 내구도를 그대로 둔다던가 등..
 */