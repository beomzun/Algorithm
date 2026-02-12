import java.util.*;
class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int row = target.length;
        int col = target[0].length;
        boolean[][] isDiff = new boolean[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                isDiff[i][j] = beginning[i][j]!=target[i][j];
            }
        }
        
        //행 비교
        int answer = 0;
        for(int i=1;i<row;i++) {
            int diffCount = 0;
            for(int j=0;j<col;j++) {
                if(isDiff[i][j]!=isDiff[0][j]) {
                    diffCount++;
                }
            }
            if(diffCount==col) {
                answer++;
                for(int k=0;k<col;k++) {
                    isDiff[i][k] = !isDiff[i][k];
                }
            } else if(diffCount==0) {
                continue;
            } else {
                return -1;
            }
        }
        
        //열 비교
        for(int j=0;j<col;j++) {
            if(isDiff[0][j]) {
                answer++;
            }
        }
        
        return Math.min(answer, row+col - answer);
    }
}
/*
동전 뒤집기는 한줄 전체 진행. 목표로 만들기 위해 몇번 뒤집어야하는가
---
최대 10x10

불가한 상황인지 판단 후, 가능하면 진행.
01011
10100
01011
10100
01011
차이 계산 후, 모든 다른줄과 동일하게 만들수없으면 불가.
---
000/111
000/000
000/000
*/