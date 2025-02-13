import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int row=0;
        int col=0;
        for(int[] size : sizes) {
            Arrays.sort(size);
            row = Math.max(row,size[0]);
            col = Math.max(col,size[1]);
        }
        return row*col;
    }
}