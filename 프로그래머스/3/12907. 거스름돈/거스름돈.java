import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] counts = new int[n+1];
        counts[0]=1;
        
        for(int now : money) {
            for(int i=now;i<=n;i++) {
                counts[i] += counts[i-now];
                counts[i] %=1_000_000_007;
            }
        }
        
        return counts[n];
    }
}