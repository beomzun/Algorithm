import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int now=1;  //컨테이너 끝에 박스번호.
        int count=0;
        for(int box : order) {
            if(box>=now) {
                while(box!=now) {
                    stack.push(now++);
                }
                now++;
                count++;
            } else {
                if (box==stack.peek()) {
                    count++;
                    stack.pop();
                    continue;
                }
                break;
            }
        }
        return count;
    }
}
/*
보조 컨테이너 = 스택
*/