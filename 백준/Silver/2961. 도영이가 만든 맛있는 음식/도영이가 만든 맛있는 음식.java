import java.util.*;
import java.io.*;
class Solution {
    int N;
    int[][] foods;
    int min = 1_000_000_000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        foods = new int[N][2];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            foods[i][0] = Integer.parseInt(st.nextToken());
            foods[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++) {
            dfs(i,1,0);
        }

        System.out.println(min);
    }
    public void dfs(int now, int salt, int bit) {
        salt *= foods[now][0];
        bit += foods[now][1];
        min = Math.min(min, Math.abs(salt - bit));
        for(int i=now+1;i<N;i++) {
            dfs(i, salt, bit);
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
재료 n개
각 재료는 쓴맛과 신맛 존재.
완성한 음식의 쓴맛과 신맛은 사용된 재료들의 쓴맛의 곱, 신맛의 곱
신맛과 쓴맛의 차이가 가장 적은 경우
nC1 + nC2 + ...nCn
 */