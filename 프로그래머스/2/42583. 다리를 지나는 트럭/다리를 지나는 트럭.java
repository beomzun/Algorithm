import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        int N = truck_weights.length;
        int w = 0;
        int time=0;
        int input=0;
        while(input<N) {
            if(q.size()==bridge_length) {
                w-=q.remove();
            }
            int nowW = truck_weights[input];
            if(w+nowW<=weight) {
                w+=nowW;
                q.add(nowW);
                input++;
            } else {
                q.add(0);
            }
            time++;
        }
        time+=bridge_length;
        return time;
    }
}