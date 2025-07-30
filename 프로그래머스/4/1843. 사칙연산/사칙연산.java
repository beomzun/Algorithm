import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int N = arr.length/2 +1;   //길이가 7이면 숫자는 4개. 0~3번째 수
        int[][] maxDP = new int[N][N];  
        int[][] minDP = new int[N][N];
        
        //초기세팅
        for(int i=0;i<N;i++) {
            Arrays.fill(maxDP[i], Integer.MIN_VALUE);
            maxDP[i][i] = Integer.parseInt(arr[i*2]);
            Arrays.fill(minDP[i], Integer.MAX_VALUE);
            minDP[i][i] = Integer.parseInt(arr[i*2]);
        }
        
        //계산 길이
        for(int i=1;i<N;i++) {
            //시작 인덱스
            for(int j=0;j+i<N;j++) {
                for(int k=j*2+1;k<(i+j)*2;k+=2) {
                    boolean plus = arr[k].equals("+");
                    if(plus) {
                        maxDP[j][j+i] = Math.max(maxDP[j][j+i],
                                                 maxDP[j][(k-1)/2]+maxDP[(k+1)/2][j+i]);
                        minDP[j][j+i] = Math.min(minDP[j][j+i],
                                                minDP[j][(k-1)/2]+minDP[(k+1)/2][j+i]);
                    } else {
                        maxDP[j][j+i] = Math.max(maxDP[j][j+i],
                                                maxDP[j][(k-1)/2] - minDP[(k+1)/2][j+i]);
                        minDP[j][j+i] = Math.min(minDP[j][j+i],
                                                 minDP[j][(k-1)/2] - maxDP[(k+1)/2][j+i]);
                    }
                }
            }
        }
        
        return maxDP[0][N-1];
    }
}
/*
1 - 3 + 5 - 8
0. 자기자신
1. 옆에 녀석과 계산 => 길이2
2. 길이3이면, 1+2 / 2+1
...
길이 N이면, 1+ N-1 / ... / N-1 +1
*/