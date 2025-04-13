import java.util.*;
import java.io.*;
class Solution {
    int max=0;
    int N;
    int[] L;
    int[] J;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        J = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            dfs(i,0,0);
        }

        System.out.println(max);
    }
    public void dfs(int idx, int sumL, int sumJ) {
        int nowL = sumL + L[idx];
        int nowJ = sumJ + J[idx];
        if(nowL<100) {
            max = Math.max(max, nowJ);
            for(int i=idx+1;i<N;i++) {
                dfs(i,nowL, nowJ);
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
i에게 인사하면 Li의 체력이 줄고, Ji의 기쁨을 얻음
최대 기쁨 구하기
 */
