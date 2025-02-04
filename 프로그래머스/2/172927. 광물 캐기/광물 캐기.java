import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dumCount=0;
        int pickCount = picks[0]+picks[1]+picks[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o2[0]-o1[0]);
        for(int i=0;i<minerals.length&&dumCount<pickCount;) {
            int sum=0;
            for(int j=0;j<5;j++) {
                if(i==minerals.length) {
                    break;
                }
                String now = minerals[i];
                if(now.equals("diamond")) {
                    sum+=25;
                } else if(now.equals("iron")) {
                    sum+=5;
                } else {
                    sum+=1;
                }
                i++;
            }
            pq.add(new int[]{sum,dumCount++});
        }
        //pq에서 꺼내면서 곡괭이 비싼놈부터 사용해서 5개또는 끝까지 계산
        while(!pq.isEmpty()) {
            int[] now = pq.remove();
            int num = now[1];
            int pick=-1;
            for(int i=0;i<3;i++) {
                if(picks[i]>0) {
                    picks[i]--;
                    pick=i;
                    break;
                }
            }
            for(int i=num*5;i<num*5+5&&i<minerals.length;i++) {
                if(pick==0) {
                    answer+=1;
                } else if(pick==1) {
                    if(minerals[i].equals("diamond")) {
                        answer+=5;
                    } else {
                        answer+=1;
                    }
                } else {
                    if(minerals[i].equals("diamond")) {
                        answer+=25;
                    } else if(minerals[i].equals("iron")) {
                        answer+=5;
                    } else {
                        answer+=1;
                    }
                }
            }
        }
        return answer;
    }
}
/*
곡괭이 종류별 개수 - 다이아 철 돌 / 자원 배열
자원 배열 5개씩 끊어서 25 5 1의 가중치로 계산. 가중치 큰 덩어리에 다이아 사용. 이때 곡괭이 수 고려해야함

*/