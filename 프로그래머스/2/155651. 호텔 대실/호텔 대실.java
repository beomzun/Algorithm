import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (t1,t2)->convert(t1[0])-convert(t2[0]));
        Queue<String[]> q = new PriorityQueue<>((t1,t2)->convert(t1[1])-convert(t2[1]));
        
        int max=0;
        for(String[] times : book_time) {
            int startTime = convert(times[0]);
            while(!q.isEmpty()) {
                if(convert(q.peek()[1])+10<=startTime) {
                    q.remove();
                    continue;
                }
                break;
            }
            q.add(times);
            max = Math.max(max, q.size());
        }
        
        return max;
    }
    
    public int convert(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
    }
}
/*
시작시간 오름차순 정렬
우선순위 큐 삽입 - 이 때 우선순위는 끝시간. 
삽입시에 삽입데이터 시작시간이 큐peek의 마무리 시간보다 클 경우 while(큐 remove) 
매순간 큐 사이즈 최대화
*/