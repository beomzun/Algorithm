import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            map.put(p, map.getOrDefault(p,0)+1);
        }
        for(String c : completion) {
            map.replace(c,map.get(c)-1);
            if(map.get(c)==0) {
                map.remove(c);
            }
        }
        
        String answer = "";
        for(String r : map.keySet()) {
            answer = r;
        }
        
        return answer;
    }
}