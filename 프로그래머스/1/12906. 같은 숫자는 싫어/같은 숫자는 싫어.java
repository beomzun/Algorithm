import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> d = new ArrayDeque<>();
        for(int val : arr) {
            if(d.isEmpty()) {
                d.addLast(val);
                continue;
            }
            if(d.peekLast()==val) {
                continue;
            } else {
                d.addLast(val);
            }
        }
        
        int[] answer = new int[d.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = d.removeFirst();
        }
        
        return answer;
    }
}