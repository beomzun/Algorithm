import java.util.*;
import java.io.*;
class Solution {
    static int[][] board;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        find(n, 0, 0);
        bw.flush();
        bw.close();
    }

    public void find(int size, int row, int col) throws IOException {
        if (same(size, row, col)) {
            bw.write(board[row][col]);
            return;
        }

        if (size != 1) {
            bw.write("(");
        }

        size /= 2;
        find(size, row, col);
        find(size, row, col + size);
        find(size, row + size, col);
        find(size, row + size, col + size);

        if (size != 0) {
            bw.write(")");
        }
    }

    public boolean same(int size, int row, int col) {
        int target = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != target) {
                    return false;
                }
            }
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
첫째 줄에는 영상의 크기를 나타내는 숫자 N 이 주어진다. N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64의 범위를 가진다.
두 번째 줄부터는 길이 N의 문자열이 N개 들어온다. 각 문자열은 0 또는 1의 숫자로 이루어져 있으며, 영상의 각 점들을 나타낸다.

과정
주어진 영상이 모두 0으로만 되어 있으면 압축 결과는 "0"이 되고, 모두 1로만 되어 있으면 압축 결과는 "1"이 된다.
만약 0과 1이 섞여 있으면 전체를 한 번에 나타내지를 못하고, 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래, 이렇게 4개의 영상으로 나누어 압축하게 되며,
이 4개의 영역을 압축한 결과를 차례대로 괄호 안에 묶어서 표현한다

출력
영상을 압축한 결과를 출력한다.

해결
재귀를 사용하여 해결
depth 깊어질 때 괄호 추가
 */