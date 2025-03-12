import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int answer = 0;
            int[] houses = new int[N];  //누적합
            houses[0] = Integer.parseInt(st.nextToken());
            for(int i=1;i<N;i++) {
                houses[i] += houses[i - 1] + Integer.parseInt(st.nextToken());
            }
            for(int i=N-1;i>M-1;i--) {
                int now = houses[i] - houses[i-M];
                if(now<K) {
                    answer++;
                }
            }
            if(houses[M-1]<K) {
                answer++;
            }
            if(N>M) {
                for(int i=M-2;i>=0;i--) {
                    int now = houses[i] + houses[N - 1] - houses[N - 1 - (M - 1 - i)];
                    if(now<K) {
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N개의 집에 각자 돈 보관중. M개의 연속된 집에서 돈 훔치기
훔친돈이 K미만인 경우의 수
---
N=M 인 경우 빙글돌아버림
 */