import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int c1,c2,c3;
        c1=c2=c3=0;
        for(int i=0;i<answers.length;i++) {
            if(p1[i%5]==answers[i]) {
                c1++;
            }
            if(p2[i%8]==answers[i]) {
                c2++;
            }
            if(p3[i%10]==answers[i]) {
                c3++;
            }
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        //i맞춘개수, i
        list.add(new int[]{c1,1});
        list.add(new int[]{c2,2});
        list.add(new int[]{c3,3});
        
        Collections.sort(list, (o1,o2)-> {
            if(o2[0]==o1[0]) {
                return o1[1]-o2[1];
            }
            return o2[0]-o1[0];
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(list.get(0)[1]);
        for(int i=1;i<3;i++) {
            if(list.get(i)[0]==list.get(i-1)[0]) {
                answer.add(list.get(i)[1]);
                continue;
            }
            break;
        }
        
        int[] ans = new int[answer.size()];
        for(int i=0;i<ans.length;i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
/*
12345
21232425
3311224455
*/