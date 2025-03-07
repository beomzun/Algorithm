import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[H];
        int[] top = new int[H];
        for(int i=0;i<N;i++) {
            int size = Integer.parseInt(br.readLine());
            if(i%2==0) {
                bottom[size]++;
            } else {
                top[size]++;
            }
        }

        for(int i=H-1;i>=2;i--) {
            bottom[i-1] += bottom[i];
            top[i-1] += top[i];
        }

        int min = N/2;
        int count=2;
        for(int i=2;i<H;i++) {
            int now = bottom[i] + top[H-i+1];
            if(now<min) {
                min = now;
                count=1;
            } else if(now==min) {
                count++;
            }
        }
        System.out.println(min + " " + count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N H / 가로 세로
석순 종유석 석순 종유석... 장애물 길이는 H보다 작다 = 위아래 둘다 이어진 장애물은 없음.
일직선으로 날아갈때 파괴해야하는 장애물 최소수와 최소수인 구간 수
---
장애물 순서는 상관없음. 길이가 중요
오름차순 정렬 후 뒤에서부터 누적합. 각 장애물은 낮은거 고를수록 더 크다.
두 장애물에 대해 누적합 과정 거친 뒤, 종유석-석순 통합 과정 진행
 */