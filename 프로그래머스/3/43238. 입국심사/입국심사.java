import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long max = 0L;
        for(int time : times) {
            max = Math.max(max, time);
        }
        long right = max * n;
        
        while(left<right) {
            long mid = (left+right)/2;
            System.out.println(mid);
            long count = 0;
            for(int time : times) {
                count += (mid/time);
            }
            if(count>=n) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        return left;
    }
}
/*
N명 입국심사. 심사원마다 걸리는 시간 다름
여러개 비어있으면 가장 빨리 끝나는곳으로 갈수잇음.
모든 사람이 심사받는데 걸리는 최소시간.
N<10억
심사관<10만
---
큐에 언제 끝날지를 넣어뒀음. -> 그리디 시간초과
---
이분탐색 -> 시간동안 몇명이나 뺄수있는가
*/