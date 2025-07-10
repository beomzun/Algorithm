import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        int left = 0;
        int right = 1;
        int max = 1;
        while (right < s.length()) {
            //right 넣을차례
            char c = s.charAt(right++);
            //있으면
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                max = Math.max(max, right - left);
                continue;
            }
            //없으면
            while(map.size()>=N) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                if(map.get(l)==0) {
                    map.remove(l);
                }
                left++;
            }
            map.put(c, 1);
            max = Math.max(max, right - left);
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*

 */