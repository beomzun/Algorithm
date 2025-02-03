import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int N = sequence.length;
        
        int start=0;
        int end=0;
        int sum=0;
        int length=Integer.MAX_VALUE;
        while(sum<k) {
            sum+=sequence[end++];
        }
        if(sum==k) {
            length = end;
            answer = new int[]{0,end-1};
        }
        if(sum>k) {
            sum-=sequence[end-1];
            end--;
        }
        
        for(int i=end;i<N;i++) {
            sum+=sequence[i];
            while(sum>k) {
                sum-=sequence[start];
                start++;
            }
            if(sum==k) {
                if(length > i-start+1) {
                    length = Math.min(length, i-start+1);
                    answer = new int[]{start, i};
                }
            }
        }
        
        return answer;
    }
}
/*
처음에 k 맞출때까지 end 이동.
while 내부 : end 하나 이동. k일때가지 이동 후 길이 갱신. k안되면 갱신은x
*/