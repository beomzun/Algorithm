import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++) {
            while(!stack.isEmpty()&&prices[stack.peek()] > prices[i]) {
                answer[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.peek()]=(N-1)-stack.peek();
            stack.pop();
        }
        return answer;
    }
}
/*

*/