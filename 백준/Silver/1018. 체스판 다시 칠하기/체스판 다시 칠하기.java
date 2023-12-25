import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String str;
        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            arr[i] = str.split("");
        }

        int min = 64;
        //총 8*8을 탐색하는 횟수
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                //각 횟수마다 8*8 탐색
                int diff = 0;
                for (int row = i; row < i+8; row++) {
                    for (int col = j; col < j + 8; col++) {
                        if ((row + col) % 2 == 0) {
                            if (!arr[row][col].equals(arr[i + 7][j + 7])) {
                                diff++;
                            }
                        } else {
                            if (arr[row][col].equals(arr[i + 7][j + 7])) {
                                diff++;
                            }
                        }
                    }
                }
                //한 세트 완료
                diff = min(diff, 64 - diff);
                min = min(min, diff);
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
