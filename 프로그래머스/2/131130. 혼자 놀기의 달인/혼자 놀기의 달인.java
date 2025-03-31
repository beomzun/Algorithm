import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] cards) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<cards.length;i++) {
            cards[i]--;
        }
        boolean[] visit = new boolean[cards.length];
        for(int i=0;i<cards.length;i++) {
            if(visit[i]) {
               continue; 
            }
            visit[i] = true;
            int count = 1;
            int cardNum = cards[i];
            while(true) {
                if(visit[cardNum]) {
                    break;
                }
                visit[cardNum] = true;
                cardNum = cards[cardNum];
                count++;
            }
            list.add(count);
        }
        if(list.size()<=1) {
            return 0;
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0)*list.get(1);
    }
}
/*
1부터 100의 카드가 있음.
2~100의 자연수 하나 골라 자연수 이하의 숫자카드준비 & 숫자만큼의 상자 준비.
각 상자에 카드 임의 삽입. 상자가 나열된 순서에 따라 1번부터 증가.
임의로 상자 하나 선택 -> 내부 카드 수의 상자번호 오픈 -> ... -> 이미 열려있을때가지 지속 -> 상자수가 1번점수
또 지속하면 2번점수
최대 점수 찾기.
*/