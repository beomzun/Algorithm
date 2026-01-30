import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoSum = wanho[0]+wanho[1];
        Arrays.sort(scores, (s1,s2) -> {
            if(s1[0]==s2[0]) {
                return s1[1]-s2[1];
            }
            return s2[0]-s1[0];
        });
        
        int maxPeer = 0;
        int rank = 1;
        for(int[] score : scores) {
            // 동료점수가 최고보다 낮다면,
            if(score[1] < maxPeer) {
                if(score[0]==wanho[0] && score[1]==wanho[1]) {
                    return -1;
                }
                continue;
            }
            maxPeer = score[1];
            
            if(score[0]+score[1] > wanhoSum) {
                rank++;
            }
        }
        return rank;
    }
}
/*
근무태도 내림차순, 동료평가 오름차순 (같으면 뒤로갈수록 점수가 높다.)
근무태도가 같다면, 내 앞사람은 나보다 동료평가가 낮다! => 탈락자X
처음에 같은 근무태도들 사이에서는 동료평가 점수가 올라갈것임. => 탈락자X
*/