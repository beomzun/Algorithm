import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int N = priorities.length;
        boolean[] visit = new boolean[N];
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities) {
            q.add(p);
        }
        
        int idx=0;
        int time=1;
        while(!q.isEmpty()) {
            int target = q.peek();
            while(true) {
                if(priorities[idx]==target) {
                    q.remove();
                    if(idx==location) {
                        return time;
                    }
                    time++;
                    idx = (idx+1)%N;
                    break;
                }
                idx = (idx+1)%N;
            }
        }
        return -1;
    }
}
/*
특정 프로세스가 몇번째에 실행되는가
*/