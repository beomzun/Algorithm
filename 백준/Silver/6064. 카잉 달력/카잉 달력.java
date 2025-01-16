import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(year(M, N, x, y)).append("\n");
        }
        System.out.println(sb);
    }

    public int year(int M, int N, int x, int y) {
        int max = minMul(M, N);
        while (x <= max) {
            int tY = x % N == 0 ? N : x % N;
            if (tY == y && N * (x / N) <= max) {
                return x;
            }
            x += M;
        }
        return -1;
    }

    public int maxDiv(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public int minMul(int a, int b) {
        return a * b / maxDiv(a, b);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1:1 9:9 10:10
1:11 2:12 3:1
...
5 +13 +13 +13...
6 +11 +11 +11...
---
10 12 3 9 => 10*a + 3 == 12*b + 9
13 11 5 6 => 13*a + 5 == 11*b + 6

3,13,23,33..일 때, 33% N ==9가 된 경우, N*몫 해봤을때 최소공배수 밑이면 ㅇㅋ
9 21 33

1에서 13

1
11 13 5 13
=> 104
 */