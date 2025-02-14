import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> l = new HashSet<>();
        for(int val : lost) {
            l.add(val);
        }
        Set<Integer> r = new TreeSet<>();
        for(int val : reserve) {
            r.add(val);
        }
        
        for(int re : reserve) {
            if(l.contains(re)) {
                l.remove(re);
                r.remove(re);
            }
        }
        for(int re : r) {
            if(l.contains(re-1)) {
                l.remove(re-1);
            } else if(l.contains(re+1)) {
                l.remove(re+1);
            }
        }
        
        return n-l.size();
    }
}
/*
총 n명, 분실 lost, 여분 reserve
*/