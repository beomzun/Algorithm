import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Double> widths = new ArrayList<>();
        list.add(k);
        int now=k;
        double width = 0;
        widths.add(0.0);
        while(now!=1) {
            int val=0;
            if(now%2==0) {
                val = now/2;
            } else {
                val = now*3 +1;
            }
            width += ((double)val+now)/2;
            widths.add((double)width);
            list.add(val);
            now = val;
        }
        
        double[] answer = new double[ranges.length];
        int n = list.size()-1;
        for(int i=0;i<ranges.length;i++) {
            int[] range = ranges[i];
            int start = range[0];
            int end = n+range[1];
            if(end<start) {
                answer[i] = -1;
                continue;
            }
            answer[i] = widths.get(end) - widths.get(start);
        }
        return answer;
    }
}