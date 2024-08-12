import java.util.*;
import java.io.*;

class Solution {
    char[][] board;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        star(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(board[i][j]);
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }

    public void star(int y, int x, int n, boolean blank) {
        //공백칸인 경우
        if (blank) {
            for (int i = y; i < y + n; i++) {
                for (int j = x; j < x + n; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }

        //공백칸은 아닌데 사이즈가 1인경우
        if (n == 1) {
            board[y][x] = '*';
            return;
        }

        //보편적인 경우
        int size = n / 3;
        int count = 1;
        for (int i = y; i < y + n; i += size) {
            for (int j = x; j < x + n; j += size) {
                star(i, j, size, count == 5);
                count++;
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
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.

과정
크기 N의 패턴은 N×N 정사각형 모양이다.
크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
***
* *
***
N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.

해결
재귀를 사용하여 크기를 줄이며 풀이.
주어진 블록을 9개로 나눈 후 블록 4개를 지나면 공백이다. boolean 사용하여 count 활용하여 공백구간인 경우 표시 
 */
