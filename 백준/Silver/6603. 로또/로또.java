import java.util.*;
import java.io.*;

class Solution {

    static int[] arr = new int[6];
    static int n;
    static int[] val;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            val = new int[n];
            for (int i = 0; i < n; i++) {
                val[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n - 5; i++) {
                dfs(0, i);
            }

            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public void dfs(int out_idx, int val_idx) throws IOException {
        if (n - val_idx < 6 - out_idx) {
            return;
        }

        arr[out_idx] = val[val_idx];
        if (out_idx == 5) {
            for (int i = 0; i < 6; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = val_idx + 1; i < val.length; i++) {
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
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다.
첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
S의 원소는 오름차순으로 주어진다.
입력의 마지막 줄에는 0이 하나 주어진다.

과정
로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.

출력
각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다.
각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.

해결
사전 순으로 출력하고, 하나의 로또 내에서 순서는 상관없으므로 재귀 호출 시 다음 인덱스값 사용.
남아있는 수의 개수가 뽑아야하는 수의 개수보다 적을 경우 리턴.
 */