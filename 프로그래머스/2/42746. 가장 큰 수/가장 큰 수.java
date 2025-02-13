import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (s1,s2)->{
            return (s2+s1).compareTo(s1+s2);
        });
        
        if(arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}
/*
우선순위 9~1,10,0
8 82 81 800 80 9 90 -> 990880
*/