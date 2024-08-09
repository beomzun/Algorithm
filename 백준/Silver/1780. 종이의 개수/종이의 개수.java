import java.util.*;
import java.io.*;

class Solution {
    static int[][] paper;
    static int minus;
    static int zero;
    static int one;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        paper = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(size, 0, 0);
        System.out.println(minus + "\n" + zero + "\n" + one);
    }

    public void find(int size, int row, int col) {
        if (same(size, row, col)) {
            switch(paper[row][col]) {
                case -1:
                    minus++;
                    break;
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
            }
            return;
        }

        size /= 3;
        find(size, row, col);
        find(size, row, col + size);
        find(size, row, col + size * 2);

        find(size, row + size, col);
        find(size, row + size, col + size);
        find(size, row + size, col + size * 2);

        find(size, row + size * 2, col);
        find(size, row + size * 2, col + size);
        find(size, row + size * 2, col + size * 2);
    }

    public boolean same(int size, int row, int col) {
        int target = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (target != paper[i][j]) {
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
N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

재귀를 사용하여 풀이 진행.
전체가 동일한 값이라면 해당 값에 +1 후 리턴. 아니라면 크기를 3으로 나누어 각 구간별로 다시 진행
 */