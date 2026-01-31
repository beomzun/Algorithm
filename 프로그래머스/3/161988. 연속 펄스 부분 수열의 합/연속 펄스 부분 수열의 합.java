import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        for(int i=0, mul = 1;i<sequence.length;i++, mul*=-1) {
            sequence[i] *= mul;
        }
        
        //전체 최대
        long max = Long.MIN_VALUE;
        //나를 포함한 최대
        long nowMax = 0;
        for(int i=0;i<sequence.length;i++) {
            nowMax = Math.max(nowMax,0) + sequence[i];
            max = Math.max(max, nowMax);
        }
        
        for(int i=0;i<sequence.length;i++) {
            sequence[i] *=-1;
        }
        
        nowMax = 0;
        for(int i=0;i<sequence.length;i++) {
            nowMax = Math.max(nowMax,0) + sequence[i];
            max = Math.max(max, nowMax);
        }
        
        return max;
    }
}
/*
부분 수열에 같은길이의 펄스수열(-1,1 ..) 을 곱한 '연속펄스부분수열'의 각 원소의 합 중 가장 큰 것
전체에 1,-1,1 적용한 후에 연속부분수열의합
그다음 전체에 -1 적용한 후에 연속부분수열의합

0
01, 1
012, 12, 2
0123, 123, 23, 3
*/