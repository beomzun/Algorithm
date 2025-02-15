import java.io.*;
import java.util.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        int min = 1;
        for(int i=2;i<N;i++) {
            if(prices[i]<=prices[min]) {
                min=i;
            }
        }

        //0을 제외한 가장 싼 녀석이 M보다 비싸면 답은 0.
        if(N==1 || prices[min]>M) {
            System.out.println(0);
            return;
        }

        M-=prices[min];
        q.add(min);
        //최고길이 완성
        min=0;
        for(int i=1;i<N;i++) {
            if(prices[i]<=prices[min]) {
                min=i;
            }
        }
        while(M>=prices[min]) {
            M-=prices[min];
            q.add(min);
        }

        int[] answer = new int[q.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = q.remove();
        }

        //nowVal은 현재 제일싼놈임.
        for(int i=0;i<answer.length;i++) {
            int nowVal = answer[i];
            for(int j=N-1;j>nowVal;j--) {
                int priceDif = prices[j] - prices[nowVal];
                if(M>=priceDif) {
                    M-=priceDif;
                    answer[i] = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int val : answer) {
            sb.append(val);
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
0을 제외한 가장 싼놈중 하나 쓰고, 전체 중에 가장 싼녀석으로 남은금액 전부소진 -> 최고길이 생성.
이 길이를 유지하면서 크기 키워가기.

6 7 8 / 21
처음에 1로 7원사용 ->14
100 으로 1원 남기기 -> 2원
200으로 1원 추가사용 ->1원
210으로 1원 추가사용 ->0원
 */
