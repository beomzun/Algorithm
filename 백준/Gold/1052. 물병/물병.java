import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int rest = N;
        int lastVal = rest;
        int bottleCount = 0;
        while (rest > 1 && bottleCount < K) {
            lastVal = (int) Math.pow(2, (int) (Math.log(rest) / Math.log(2)));
            rest = rest - lastVal;
            bottleCount++;
        }
        if (bottleCount < K || (bottleCount == K && rest == 0)) {
            System.out.println(0);
            return;
        }

        System.out.println(lastVal - rest);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
같은양의 물병 두개 합치기
N개의 물병이 있고, K개까지 한번에 옮길 수 있음.
계속 로그
8/ 4 / 1
 */