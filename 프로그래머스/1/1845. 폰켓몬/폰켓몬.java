import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        return Math.min(set.size(), nums.length/2);
    }
}
/*
N/2개 고를수 있고, 최대한 다른 종류 고르기
최대한 서로 다른 종류 고르기
*/