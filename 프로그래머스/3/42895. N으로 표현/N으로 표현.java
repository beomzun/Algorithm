import java.util.*;
class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] sets = new HashSet[9];
        for(int i=1;i<9;i++) {
            sets[i] = new HashSet<>();
        }
        for(int i=1;i<9;i++) {
            int val = Integer.parseInt(String.valueOf(N).repeat(i));
            if(val==number) {
                return i;
            }
            sets[i].add(val);
            for(int j=1;i>j;j++) {
                for(int large : sets[i-j]) {
                    for(int small : sets[j]) {
                        val = large-small;
                        if(val==number) {
                            return i;
                        }
                        sets[i].add(val);
                        
                        val = large+small;
                        if(val==number) {
                            return i;
                        }
                        sets[i].add(val);
                        
                        val = large*small;
                        if(val==number) {
                            return i;
                        }
                        sets[i].add(val);
                        
                        if(small==0) {
                            continue;
                        }
                        val = large/small;
                        if(val==number) {
                            return i;
                        }
                        sets[i].add(val);
                    }
                }
            }
        }
        return -1;
    }
}
/*
N만 사용해서 number를 표현할때 N의 최소사용수
1개 : 단일수
2개 : 55, 단일수 사칙연산
3개 : 555, 2개1개 사칙연산, 1개2개 사칙연산
4개 : 5555, 3개1개 사칙연산, 2개2개, 1개3개
...
9개 -> -1
*/