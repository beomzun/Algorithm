import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int N = cards.length;
        
        int life = 0;
        //실제 보유
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N/3;i++) {
            set.add(cards[i]);
            if(set.contains(N+1 - cards[i])) {
                life++;
            }
        }
        
        //예비 보유
        Set<Integer> pass = new HashSet<>();
        int time = 1;
        int idx = N/3;
        int tmpLife = 0;
        
        while(idx<N && coin >=0) {
            // 어디부터 어디까지 보게할지
            // => time이 t, 생명이 l 이면, 
            // 현위치는 N/3+(time-1)*2 + l 에 있음. N/3+ (time-1)*2 + l*2까지.
            // => time이 1이면 < N/3+2까지 / time이 3이면 N/3+6
            // idx부터 내 현위치 + 생명까지만 보도록
            
            int next = N/3 + time*2 + life*2;
            //생명으로 버틸수 있을 때까지 보기
            for(;idx<next && idx<N;idx++) {
                //하나짜리 럭키
                if(set.contains(N+1 - cards[idx])) {
                    if(coin>=1) {
                        coin--;
                        life++;
                    }
                }
                // 둘 다 사야함
                else if(pass.contains(N+1 - cards[idx])) {
                    pass.remove(N+1 - cards[idx]);
                    tmpLife++;
                }
                // 모솔
                else {
                    pass.add(cards[idx]);
                }
            }
            
            if(life>0) {
                life--;
                time++;
            } else {
                if(tmpLife>0 && coin>=2) {
                    tmpLife--;
                    coin-=2;
                    time++;
                } else {
                    break;
                }
            }
        }
        while(life>0) {
            life--;
            time++;
        }
        
        return time;
    }
}
/*
카드 뭉치 카드 1~n / 동전 coin 개
카드 뽑는 순서 정해져있음.
0. n/3 장을 뽑아 모두 가진다
1. 각 라운드가 시작할때 카드 두장 뽑기. -> 뽑을 카드 모자라면 종료 / 동전 하나를 소모해 갖거나 그냥 버릴수 있음
2. 카드에 적힌 수의 합이 n+1이 되도록 카드 두장을 내고 다음 라운드 진행 가능. 못내면 종료
---
동전수와 카드배열이 주어졌을때 최대 도달 가능한 라운드수 구하기
n<1000 / coin<=n \ n은 6의배수임. => n<=996
332장 갖고 시작. 664장을 두장씩 332라운드
버리기 하나갖기 하나갖기 두개갖기 -> 매라운드마다 4가지 경우의수 4^332 => 완탐X

그리디?
- 2장 뽑기.
- 현재 짝을 내가 들고있는지 || 필요한 짝을 내가 넘겼는지
- 구매하면 코인 소비 -> 다음 라운드로.
- 못버리거나 카드 없으면 종료
=> 예 3번 반례. 지금갖고 있는게아닌, 새로운거 2개 사서 낭비.
- 현재 생명으로 볼 수 있는 카드 모두 탐색 -> 현재 갖고있는것과 짝인 것 우선해서 1차 탐색, 두개사서 짝맞출수있는것 2차탐색.
- 2차탐색은 예비생명으로 넘겨두기. 1차탐색에서 없고 생명다쓰면 붕대느낌으로?
*/