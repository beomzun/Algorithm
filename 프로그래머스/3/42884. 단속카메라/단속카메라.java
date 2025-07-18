import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1,o2)->{
            if(o1[0]==o2[0]) {
                return o2[1]-o1[1];
            }
            return o1[0] - o2[0];
        });
        
        Stack<int[]> stack = new Stack<>();
        for(int[] route : routes) {
            //비엇으면 추가
            if(stack.isEmpty()) {
                stack.push(route);
                continue;
            }
            //겹치면 반영
            if(stack.peek()[1] >= route[0]) {
                stack.push(new int[]{route[0], Math.min(stack.pop()[1], route[1])});
                continue;
            }
            //안겹치면 추가
            stack.push(route);
        }
        
        return stack.size();
    }
}
/*
시작순정렬, 스택 사용
처음에 하나 삽입. 지금의 시작과 peek이 겹친다면, 제거하고 겹치는 부위만 삽입. 쭉쭉하다가 안겹치면 count++
*/