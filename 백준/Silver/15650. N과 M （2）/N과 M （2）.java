import java.util.*;
import java.io.*;

class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visit;
    static int[] arr;
    static int n;
    static int m;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        find(1,0);
        bw.flush();
        bw.close();
    }

    public void find(int now, int count) throws IOException {
        if (now > n) {
            return;
        }

        //골랐을 때
        visit[now] = true;
        //m개인 경우
        if (count + 1 == m) {
            for (int i = 1; i <= now; i++) {
                if (visit[i]) {
                    bw.write(i + " ");
                }
            }
            bw.write("\n");
        }
        //m개 아닌 경우
        find(now + 1, count + 1);

        //안 골랐을 때
        visit[now] = false;
        find(now + 1, count);
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
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

해결
선택 유무에 따라 경우를 나누어 m개를 선택했을 때 버퍼에 작성했으나 내림차순으로 출력됨
---
dfs를 적용하여 방문했을때 먼저 처리하여 오름차순으로 출력되도록 수정
 */
