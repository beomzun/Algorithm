import java.util.*;
class Solution {
    int max=0;
    int N;
    boolean[] visit;
    int[][] dun;
    public int solution(int k, int[][] dung) {
        N = dung.length;
        visit = new boolean[N];
        dun = dung;
        for(int i=0;i<N;i++) {
            if(dun[i][0]>k) {
                continue;
            }
            visit[i]=true;
            dfs(1,k-dun[i][1]);
            visit[i]=false;
        }
        
        return max;
    }
    public void dfs(int count, int hp) {
        max = Math.max(max,count);
        
        for(int i=0;i<N;i++) {
            if(visit[i] || dun[i][0]>hp) {
                continue;
            }
            visit[i]=true;
            dfs(count+1,hp-dun[i][1]);
            visit[i]=false;
        }
    }
}
/*
최소필요피로도,소모피로도 -> 탐험 가능한 최대 던전수
*/