import java.util.*;
import java.io.*;

class Solution {
    char[][] board;
    int n;
    public void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = sc.nextInt();
        board = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                board[i][j] = ' ';
            }
        }
        draw(0, n-1, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public void draw(int row, int col, int size) {
        //제일 작은 삼각형
        if (size == 3) {
            board[row][col] = '*';
            board[row + 1][col - 1] = '*';
            board[row + 1][col + 1] = '*';
            for (int i = col - 2; i <= col + 2; i++) {
                board[row + 2][i] = '*';
            }
            return;
        }

        size /= 2;
        draw(row, col, size);
        draw(row + size, col - size, size);
        draw(row + size, col + size, size);
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
첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)

과정
2로 나누면서 3일 때까지 재귀 -> 24->12->6->3
전체 크기는 *2 -1
0-23 24-47
높이 h -> 밑 2h-1

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.

해결
배열을 사용하지 않고 수학적으로 계산하려했으나 실패
---
재귀를 사용하여 풀이
크기를 2로 나누어 제일 작은 크기(3)의 삼각형이 나올때까지 호출
3이 아니라면 세 개의 구간 1. 윗꼭짓점, 2. 왼쪽 아래, 3. 오른쪽 아래
2,3은 열의 가운데 인덱스 =col을 기준으로 size만큼 좌우로 이동하여 호출  
 */