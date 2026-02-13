class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        int minR = x;
        int maxR = x;
        int minC = y;
        int maxC = y;
        for(int i=queries.length-1;i>=0;i--) {
            int[] query = queries[i];
            int dir = query[0];
            int move = query[1];
            if(dir==0) {
                maxC+=move;
                maxC = Math.min(maxC, m-1);
                if(minC!=0) {
                    minC+=move;
                    if(minC>=m) {
                        return 0;
                    }
                }
            } else if(dir==1) {
                minC-=move;
                minC = Math.max(minC,0);
                if(maxC!=m-1) {
                    maxC-=move;
                    if(maxC<0) {
                        return 0;
                    }
                }
            } else if(dir==2) {
                maxR +=move;
                maxR = Math.min(maxR,n-1);
                if(minR!=0) {
                    minR+=move;
                    if(minR>=n) {
                        return 0;
                    }
                }
            } else {
                minR-=move;
                minR = Math.max(minR,0);
                if(maxR!=n-1) {
                    maxR-=move;
                    if(maxR<0) {
                        return 0;
                    }
                }
            }
        }
        
        return (maxR-minR+1L)*(maxC-minC+1);
    }
}
/*
거꾸로 가면서 지금까지 이 위치에만 있으면 돼 -> 각 칸 말고 범위로 생각하자.
---
위행,아래행,좌열,우열 네 변수로 범위 관리
시작은 y,x로 동일
두 변수의 크기가 교차되지 않도록 관리.
범위 조정 시 현재 범위가 끝부분을 포함하는지 확인
*/