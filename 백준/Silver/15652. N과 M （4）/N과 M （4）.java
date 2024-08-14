import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int m;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        for (int i = 1; i <= n; i++) {
            dfs(0, i);
        }
        bw.flush();
        bw.close();
    }

    public void dfs(int index, int val) throws IOException {
        if (index >= m || val > n) {
            return;
        }

        arr[index] = val;
        if (index == m - 1) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }

        for (int i = val; i <= n; i++) {
            dfs(index + 1, i);
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
1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

해결
재귀 사용 -> 반복문 내부에서 다음 인덱스 값을 현재값부터 n까지 
 */