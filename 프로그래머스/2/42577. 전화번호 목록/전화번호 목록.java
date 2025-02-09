import java.util.*;
class Solution {
    Trie root = new Trie();
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1,o2)->o2.length()-o1.length());
        for(String num : phone_book) {
            Trie now = root;
            for(int i=0;i<num.length();i++) {
                int val = Character.getNumericValue(num.charAt(i));
                if(i==num.length()-1&&now.trie[val]!=null) {
                    return false;
                }
                if(now.trie[val]==null) {
                    now.trie[val] = new Trie();
                }
                now = now.trie[val];
            }
        }
        return true;
    }
}
class Trie {
    Trie[] trie = new Trie[10];
}