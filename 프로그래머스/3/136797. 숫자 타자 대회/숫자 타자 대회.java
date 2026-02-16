import java.util.*;
class Solution {
    int[][][] memo;
    String numbers;
    public int solution(String numbers) {
        memo = new int[numbers.length()][10][10];
        this.numbers = numbers;
        
        return dfs(0,4,6);
    }
    
    // L,R 상황에서 idx번째를 해결하는 가장 적은 비용
    public int dfs(int idx, int L, int R) {
        if(idx==numbers.length()) {
            return 0;
        }
        
        if(memo[idx][L][R]!=0) {
            return memo[idx][L][R];
        }
        
        int target = Character.getNumericValue(numbers.charAt(idx));
        int min = Integer.MAX_VALUE;
        
        if(R!=target) {
            min = Math.min(min, dfs(idx+1,target,R) + getDis(L,target));
        }
        
        if(L!=target) {
            min = Math.min(min, dfs(idx+1,L,target)+ getDis(R,target));
        }
        
        memo[idx][L][R] = min;
        
        return min;
    }
    
    public int getDis(int a, int b) {
        if(a==b) {
            return 1;
        }
        int[] aPos = getPos(a);
        int[] bPos = getPos(b);
        
        int rD = Math.abs(aPos[0]-bPos[0]);
        int rC = Math.abs(aPos[1]-bPos[1]);
        
        return Math.min(rD,rC)*3 + Math.abs(rD-rC)*2;
    }
    public int[] getPos(int a) {
        if(a==0) {
            return new int[]{3,1};
        }
        return new int[]{(a-1)/3, (a-1)%3};
    }
}
/*
4,6에서 시작.
제자리 1 / 상하좌우 2 / 대각선 3 / 그 이외는 최소합
문자열 순서대로 누르는 가장 빠른 시간.
해당 위치에 손가락 있다면, 반드시 해당 손가락 사용.
---
3차원 메모이제이션,,,
*/