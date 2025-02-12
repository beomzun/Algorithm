import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int scovil : scoville) {
            q.add(scovil);
        }
        int count=0;
        while(q.size()>1&&q.peek()<K) {
            q.add(q.remove()+q.remove()*2);
            count++;
        }
        if(q.peek()<K) {
            return -1;
        }
        return count;
    }
}