import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int enemyLen = enemy.length;
        if(k>=enemyLen) {
            return enemyLen;
        }
        
        int answer = 0;
        int restN = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e : enemy) {
            //남은 수가 적보다 크면 삽입.
            pq.add(e);
            if(n>=e) {
                n-=e;
                answer++;
                continue;
            }
            //무적권이 남아있고, 큐가 차있다면 -> N이 적보다 커질때까지 무적권 사용해서 복원
            n-=e;
            while(k>0 && !pq.isEmpty() && n<0) {
                k--;
                n +=pq.remove();
            }
            if(n<0) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}
/*
처음에 병사 n마리
매 라운드마다 enemy 마리의 적 등장 -> 남은 병사 중 enemy만큼 소모해서 적을 막을 수 있음
남은 병사보다 적이 더 많으면 게임 종료
무적권 스킬 사용시 해당 턴 넘김. K번 가능
최대 몇라운드까지 막을 수 있는가?
---
1. 무적권 >= 길이
2. 적 수를 우선순위큐에 삽입 -> 전체 적 수가 남은 병사수를 넘은경우 큐에서 하나 제거후 병사수복원.
*/