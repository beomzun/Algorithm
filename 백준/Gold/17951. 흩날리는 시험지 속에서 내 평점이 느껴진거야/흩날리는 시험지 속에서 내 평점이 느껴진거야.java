import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //시험지 수
        int K = Integer.parseInt(st.nextToken());   //그룹 수

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int min = 100_000;
        int right = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            min = Math.min(min, arr[i]);
        }
        int left = min;
        while(left <= right) {
            int groupCount = 0;
            int mid = (left+right)/2;
            int now = 0;
            for(int i=0;i<N;i++) {
                now += arr[i];
                if(now >= mid) {
                    now = 0;
                    groupCount++;
                }
            }
            if(groupCount < K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
시험지가 너무 많아 야외시험ㅋㅋ
날아간 시험지를 현재 순서 그대로 K개의 그룹으로 나눈 뒤 각 그룹에서 맞은 문제 수의 합을 구하여 이 중 최소가 시험 점수
받을수있는 최대점수 \ 현수가 푼 문제는 모두 맞았음
시험지는 그룹수 이상이다.
---
제일 작은 그룹들 계속 병합. -> 어떻게? 인덱스화가 매우 복잡
매개변수탐색. 전체 그루핑이 가능한 점수를 매겨변수로 두고 진행.
 */