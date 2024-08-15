import java.util.*;
import java.io.*;

class Solution {
    static int m;
    static int n;
    static char[] arr;
    static char[] val;
    static char[] moeum = {'a', 'e', 'i', 'o', 'u'};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        val = new char[n];
        arr = new char[m];

        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            val[i] = s.charAt(2 * i);
        }
        Arrays.sort(val);

        for (int i = 0; i <= n - m; i++) {
            dfs(0, i);
        }

        bw.flush();
        bw.close();
    }

    public void dfs(int out_idx, int val_idx) throws IOException {
        if (n - val_idx < m - out_idx) {
            return;
        }

        arr[out_idx] = val[val_idx];
        if (out_idx == m - 1) {
            if (!isCorrect()) {
                return;
            }

            for (int i = 0; i < m; i++) {
                bw.write(arr[i]);
            }
            bw.write("\n");
            return;
        }

        for (int i = val_idx + 1; i < n; i++) {
            dfs(out_idx + 1, i);
        }
    }

    public boolean isCorrect() {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i] == moeum[j]) {
                    count++;
                    break;
                }
            }
        }

        if (count < 1 || m - count < 2) {
            return false;
        }
        return true;
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
첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15)
다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다.
주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.

과정
암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
알파벳이 암호에서 증가하는 순서로 배열
C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.

출력
각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.

해결
알파벳 정렬하여 오름차순으로 재귀 시작
중복 없으므로 재귀 호출시 다음인덱스부터 시작
남은 알파벳 개수가 채워야할 수보다 적은 경우 리턴
다 만들어진 암호에서 모음개수 확인
 */