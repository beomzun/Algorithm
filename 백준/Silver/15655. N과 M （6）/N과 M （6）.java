import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int m;
    static int[] val;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        val = new int[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);

        for (int i = 0; i < n; i++) {
            dfs(0, i);
        }
        bw.flush();
        bw.close();
    }

    public void dfs(int out_idx, int val_idx) throws IOException {
        if (out_idx >= m || val_idx >= n) {
            return;
        }

        arr[out_idx] = val[val_idx];
        if (out_idx == m - 1) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }

        for (int i = val_idx + 1; i < n; i++) {
            dfs(out_idx + 1, i);
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
고른 수열은 오름차순이어야 한다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

해결
출력 배열과 숫자배열 사용 -> 출력과 수열 내부 모두 오름차순이므로 이전 인덱스의 방문여부는 확인할 필요없음
반복문 내부에서 다음 인덱스의 값을 증가시키며 재귀 호출
 */