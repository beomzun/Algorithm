import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (d1,d2)->{
            if(d1[col-1]==d2[col-1]) {
                return d2[0]-d1[0];
            }
            return d1[col-1]-d2[col-1];
        });
        
        int base=0;
        for(int i=row_begin-1;i<=row_end-1;i++) {
            int now=0;
            for(int j=0;j<data[0].length;j++) {
                now+=data[i][j]%(i+1);
            }
            System.out.println(now);
            base = base^now;
        }
        return base;
    }
}