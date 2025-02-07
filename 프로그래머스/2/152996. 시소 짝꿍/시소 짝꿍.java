import java.util.*;
class Solution {
    public long solution(int[] weights) {
        int[] size = new int[901]; //100~1000
        for(int weight : weights) {
            size[weight-100]++;
        }
        
        long answer=0L;
        for(int i=0;i<901;i++) {
            if(size[i]>0) {
                for(int j=i;j<901;j++) {
                    if(size[j]==0) {
                        continue;
                    }
                    if(i==j &&size[i]>=2) {
                        answer += (long)size[i]*(size[i]-1)/2;
                        continue;
                    }
                    
                    int p1=i+100;
                    int p2=j+100;
                    if(p1*4==p2*3 || p1*4==p2*2 || p1*3==p2*2) {
                        answer += (long)size[i]*size[j];
                    }
                }
            }
        }
        return answer;
    }
}
/*
무게별 사람 수 구해서

*/