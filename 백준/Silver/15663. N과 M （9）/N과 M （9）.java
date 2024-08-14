import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int m;
    static int[] arr;
    static int[] val;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        val = new int[n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);

        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (val[i] == prev) {
                continue;
            }

            visit[i] = true;
            dfs(0, i);
            visit[i] = false;

            prev = val[i];
        }

        bw.flush();
        bw.close();
    }

    public void dfs(int out_idx, int val_idx) throws IOException {
        if (val_idx >= n) {
            return;
        }

        arr[out_idx] = val[val_idx];
        if (out_idx == m - 1) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (val[i] == prev || val_idx == i || visit[i]) {
                continue;
            }

            visit[i] = true;
            dfs(out_idx + 1, i);
            visit[i] = false;

            prev = val[i];
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
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

과정
N개의 자연수 중에서 M개를 고른 수열

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

해결
입력받는 수 중 중복되는 수가 있을 수 있음
출력은 오름차순이나 수열 내부는 오름차순이 아니어도되므로 반복문 내부에서 다음 인덱스 값으로 제일 작은 수부터 재귀 호출
이 때 이전 수와 동일한 수이면 패스
---
3개 이상의 조합인 경우 방문 배열을 사용하여 추가 확인 필요

반례
8 4
1 2 3 4 1 2 3 4
 */