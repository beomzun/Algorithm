import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        for(int[] m : targets) {
            pq.add(m);
        }
        
        int count=0;
        while(!pq.isEmpty()) {
            int edge = pq.peek()[1];
            while(!pq.isEmpty() && pq.peek()[0]<edge) {
                pq.remove();
            }
            count++;
        }
        
        return count;
    }
}
/*
그리디
공격미사일의 끝부분 오름차순으로 정렬.
큐에는 공격미사일의 시작부분 오름차순으로 정렬.
끝부분에 맞춰 그 이전의 시작 오름차순은 out.
*/