import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int N = tangerine.length;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int last=0;
        int count=0;
        for(int i=0;i<N;i++) {
            if(tangerine[i]!=last) {
                last = tangerine[i];
                q.add(count);
                count=1;
            } else {
                count++;
            }
            if(i==N-1) {
                q.add(count);
            }
        }
        
        int sum=0;
        int kinds=1;
        while(!q.isEmpty()) {
            sum+=q.remove();
            if(sum>=k) {
                break;
            }
            kinds++;
        }
        return kinds;
    }
}
/*
종류가 많은수들로 k개 맞추기
정렬 -> 해당값의 개수 확인, pq에 개수 내림차순으로 삽입. 빼면서 k 이상이면 종료. 이때크기별 개수만 저장해도됨.
*/