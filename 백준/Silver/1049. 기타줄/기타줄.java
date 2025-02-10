import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] brands = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            brands[i][0] = Integer.parseInt(st.nextToken());
            brands[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        int div = N/6;
        int minP = Integer.MAX_VALUE;
        for (int[] p : brands) {
            minP = Math.min(minP, Math.min(p[0],p[1]*6));
        }
        answer += (minP * div);

        N -= (div * 6);
        N = Math.max(N,0);
        int mod = N % 6;
        if(mod>0) {
            minP = Integer.MAX_VALUE;
            for (int[] p : brands) {
                minP = Math.min(minP, Math.min(p[0],p[1]*mod));
            }
            answer += minP;
        }

        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N개가 끊어지고 M개의 브랜드가 있음.
M개의 브랜드에서 전체금액 낱개금액이 주어짐.
끊어진 개수가 6 이상인 경우 -> 전체 돌면서 6개 사는게 가장 싼 가격 찾아서 6의 배수만큼 구입
6 이하인 경우 -> 전체 돌면서 한세트사거나 개수사거나 비교
 */