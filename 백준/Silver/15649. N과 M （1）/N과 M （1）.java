import java.util.*;
import java.io.*;

class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visit;
    static int[] arr;
    static int m;
    static int n;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        arr = new int[n + 1];
        dfs(0);
        bw.flush();
        bw.close();
    }

    public void dfs(int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visit[i]=false;
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
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

과정
자연수 N과 M이 주어졌을 때, "1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열"을 모두 구하는 프로그램을 작성하시오.

출력
중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

해결
전체개수 nPm
---
크기n의 방문여부 배열과 크기m의 출력배열을 사용
1부터 n까지 방문하며 방문하지 않았다면 방문배열 표시, 출력배열 저장 후 depth 증가
depth가 m과 같다면 출력배열을 출력버퍼에 작성 후 리턴
 */