import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long count=0;
        for(int i=1;i<=r2;i++) {
            int bigY = (int)Math.floor(Math.sqrt(Math.pow(r2,2)-Math.pow(i,2)));
            int smallY=0;
            if(r1>=i) {
                smallY = (int)Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(i,2)));
            }
            count+=(bigY-smallY+1);
        }
        count *=4;
        return count;
    }
}