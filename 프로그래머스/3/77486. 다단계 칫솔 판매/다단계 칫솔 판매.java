import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();     //판매원 인덱스
    Map<String, String> parent = new HashMap<>();   //부모
    int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amount) {
        answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++) {
            map.put(enroll[i], i);
        }
        
        for(int i=0;i<enroll.length;i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        for(int i=0;i<sellers.length;i++) {
            String seller = sellers[i];
            int price = amount[i]*100;
            dfs(seller, price);
        }
        
        return answer;
    }
    
    public void dfs(String seller, int price) {
        int rest = (int)(price*0.1);
        if(rest<1) {
            answer[map.get(seller)]+=price;
        } else {
            answer[map.get(seller)]+=price-rest;
            String p = parent.get(seller);
            if(!p.equals("-")) {
                dfs(p, rest);
            }
        }
    }
}
/*
판매액의 10%는 자신의 추천인에게 상납.
중간 관리자는 판매액 뿐만 아니라, 자신이 추천한 사람에게서 받은 10%에서 10%를 자신의 추천인에게 상납.
---
enroll - 판매원 이름, 조직에 참여한 순서임. / 1만명.
referral - enroll의 i번째 사람을 조직에 참여시킨 사람의 이름.
seller - N번째 주문을 성공한 판매원 이름. / 기록 10만개
amount - N번째 주문의 수량. **판매액의 수량*100원. / 100이하=판매액 10000원이하.=> 최대 4번 올라감.
---
enroll의 이름순으로 이익금의 총합을 출력하시오.
---
합쳐서 올리면 원래라면 절사돼서 안올라갈것도 올라갈수있음.
*/