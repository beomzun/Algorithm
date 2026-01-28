import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!hasWord(words, target)) {
            return 0;
        }
        
        Set<String> set = new HashSet<>();
        for(String word: words) {
            set.add(word);
        }
        
        Queue<String> q = new ArrayDeque<>();
        q.add(begin);
        int len = begin.length();
        int time = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                ArrayList<String> list = new ArrayList<>();
                String s = q.remove();
                for(String key: set) {
                    int count = 0;
                    for(int i=0;i<len;i++) {
                        if(s.charAt(i)!=key.charAt(i)) {
                            count++;
                        }
                    }
                    if(count==1) {
                        if(key.equals(target)) {
                            return time;
                        }
                        list.add(key);
                        System.out.println(key);
                    }
                }
                for(String key: list) {
                    q.add(key);
                    set.remove(key);
                }
            }
            time++;
        }
        return 0;
    }
    
    public boolean hasWord(String[] words, String target) {
        for(String word: words) {
            if(word.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
/*
begin 단어에서 target 단어로 몇단계를 거쳐 변환할수있는지
words 안에 있는 단어로만 바꿔야하며, 바꿀때는 한번에 하나의 글자만 바꿀수있음
중복 단어없음.
변환불가한 경우도 있음.
*/