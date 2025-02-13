import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int totalCount = brown+yellow;
        int[] answer = new int[2];
        for(int col=3;col<=totalCount/col;col++) {
            int row = totalCount/col;
            if(col*row!=totalCount || (row-2)*(col-2)!=yellow) {
                continue;
            }
            answer[0]=row;
            answer[1]=col;
        }
        return answer;
    }
}
/*
더하면 전체 카펫 크기
2*(row+col-1) 가 전체 크기
가운데크기는 row-2 * col-2
*/