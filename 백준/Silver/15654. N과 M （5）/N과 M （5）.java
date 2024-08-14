import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int m;
    static int[] val;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        val = new int[n];
        arr = new int[m];
        visit = new boolean[n];

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

    public void dfs(int out_index, int val_index) throws IOException {
        if (out_index >= m || val_index >= n) {
            return;
        }

        visit[val_index] = true;
        arr[out_index] = val[val_index];

        if (out_index == m - 1) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(out_index + 1, i);
                visit[i] = false;
            }
        }
        visit[val_index] = false;
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
오름차순 출력을 위해 입력받은 수 정렬
3개의 배열 사용 = 방문여부 배열 \ 숫자 배열 \ 출력 배열
재귀를 사용 -> 정렬된 배열에서 처음부터 방문여부 확인 후 방문하지 않았다면 출력 배열에 저장
 */