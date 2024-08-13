import java.util.*;
import java.io.*;

class Solution {
    static int n;
    //각 인덱스값을 열로 생각 -> 0번 인덱스 값 3인 경우 0,3 -> 퀸 위치 depth,col
    static int[] queen;
    static int count = 0;

    public void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queen = new int[n];

        nQueen(0);

        System.out.println(count);
    }

    public void nQueen(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            queen[depth] = i;
            if (empty(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public boolean empty(int depth) {
        for (int i = 0; i < depth; i++) {
            //열
            if (queen[i] == queen[depth]) {
                return false;
            }
            //대각선
            if (Math.abs(i - depth) == Math.abs(queen[i] - queen[depth])) {
                return false;
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

과정

출력

해결
배열에 표시하려햇으나 돌아왔을때 이전에 방문했다는 표시를 해제해줘야하는 문제..
---
본 함수에서 반복문을 통해 첫 행에 값을 넣어주려(nqueen(col)호출)했으나 depth 처리 곤란해짐
---
일차원 배열을 활용. 인덱스, 인덱스값 = 행, 열 로 처리
 */