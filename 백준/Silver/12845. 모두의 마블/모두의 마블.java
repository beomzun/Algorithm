import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int idx = -1;
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }

        int left = idx-1;
        int right = idx+1;
        int gold = 0;
        while (left >= 0 && right < N) {
            if(arr[right] > arr[left]) {
                gold += (max+arr[right++]);
            } else {
                gold += (max+arr[left--]);
            }
        }

        if(left==-1) {
            while(right!=N) {
                gold+=(max+arr[right++]);
            }
        } else {
            while(left!=-1) {
                gold+=(max+arr[left--]);
            }
        }

        System.out.println(gold);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
순서가 매겨진 카드가 있음. 각 카드는 레벨을 갖고있음.
카드 A에 B를 붙이려면 아래의 조건을 만족해야한다
1. 인접한 카드
2. 업그레이드된 카드 A의 레벨은 변하지 않음
카드 합성시 두 카드 레벨의 합만큼 골드를 받음
---
최대 골드 출력. 제일 큰놈 기준으로 좌우 투포인터로 골드 합치기
 */