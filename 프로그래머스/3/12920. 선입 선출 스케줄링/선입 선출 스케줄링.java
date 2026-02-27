import java.util.*;
class Solution {
    int[] cores;
    public int solution(int n, int[] cores) {
        if(cores.length>=n) {
            return n;
        }
        this.cores = cores;
        
        int minT = 0;
        int maxT = 10000*n / cores.length;
        while(minT<maxT) {
            int mid = (minT+maxT)/2;
            int count = cal(mid);
            if(count>=n) {
                maxT = mid;
            } else {
                minT = mid+1;
            }
        }
        
        //T-1시간까지는 몇개 시작했는지
        int pastCounts = cal(maxT-1);
        
        for(int i=0;i<cores.length;i++) {
            if(maxT%cores[i]==0) {
                pastCounts++;
                if(pastCounts==n) {
                    return i+1;
                }
            }
        }
        
        return -1;
    }
    
    public int cal(int t) {
        int result = cores.length;
        for(int time : cores) {
            result += t/time;
        }
        
        return result;
    }
}
/*
작업 n개
CPU 코어는 여러개. 각 코어별로 작업처리 시간이 다름
2개 이상의 코어가 남을 경우, 앞의 코어부터 작업 처리
---
마지막 작업을 처리하는 코어 번호
코어 만개
처리 시간 만
일 개수 5만
---
PQ
- 언제 끝나는지(오름차순), 코어 번호(오름차순)
---
시간초과 -> 이분탐색

*/