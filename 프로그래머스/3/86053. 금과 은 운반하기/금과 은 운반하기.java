import java.util.*;
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 1;
        long right = (long)1_000_000_000*2 * 100_000*2;
        while(left<right) {
            long mid = (left+right)/2;
            long totalG = 0L;
            long totalS = 0L;
            long totalW = 0L;
            for(int i=0;i<g.length;i++) {
                long moveCount = mid/(2L*t[i]);
                if(mid % (2*t[i])>=t[i]) {
                    moveCount++;
                }
                
                totalG += Math.min(g[i], moveCount*w[i]);
                totalS += Math.min(s[i], moveCount*w[i]);
                totalW += Math.min(g[i]+s[i], moveCount*w[i]);
            }
            
            if(totalG>=a && totalS>=b && totalW>=a+b) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        return right;
    }
}
/*
새 도시 짓기 -> 금 a, 은 b 필요
i번 도시에는 금 g[i], 은 s[i], 그리고 트럭 한대 있음. 이 트럭은 새 도시랑 이 장소만 왕복가능
편도 이동하는데 t[i], 한번에 w[i]만큼 운반
---
새 도시 짓는데 몇시간 걸리는가?
*/