class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long left=1;
        long right=100_000;
        while(left<right) {
            long time=0;
            long answer = (left+right)/2;
            for(int i=0;i<diffs.length;i++) {
                if(answer<diffs[i]) {
                    if(i==0) {
                        time += (diffs[i]-answer)*times[i]+times[i];
                    } else {
                        time += (diffs[i]-answer)*(times[i]+times[i-1])+times[i];
                    }
                } else {
                    time += times[i];
                }
            }
            if(time<=limit) {
                right = answer;
            } else {
                left = answer+1;
            }
        }
        return left;
    }
}
/*
diff : 퍼즐 난이도들 1-100_000
time : 퍼즐 소요시간들
limit : 전체 제한시간
*/