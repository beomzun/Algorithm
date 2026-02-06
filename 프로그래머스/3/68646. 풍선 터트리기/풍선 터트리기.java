class Solution {
    public int solution(int[] a) {
        int len = a.length;
        boolean[][] bigger = new boolean[2][len];
        int min = 1_000_000_000;
        for(int i=0;i<len;i++) {
            bigger[0][i] = a[i]<min;
            min = Math.min(min, a[i]);
        }
        min = 1_000_000_000;
        for(int i=len-1;i>=0;i--) {
            bigger[1][i] = a[i]<min;
            min = Math.min(min, a[i]);
        }
        
        int count = 0;
        for(int i=0;i<len;i++) {
            if(bigger[0][i] || bigger[1][i]) {
                count++;
            }
        }
        
        return count;
    }
}
/*
n개의 풍선, 모두 다른 숫자, 1개남을때까지 터트리기
인접한 두 풍선 고른뒤, 하나 펑
터져서 빈 공간 생기면, 서로 밀착
두 풍선 중 번호가 더 작은 풍선은 한번만 터트릴수있음
---
풍선 100만개
끝까지 남기는 것이 가능한 풍선의 개수 구하기.
---
끝까지 남긴다->나를 기준으로 좌우로 나누었을때, 좌우 중 적어도 한곳의 최소값은 나보다 커야한다.
*/