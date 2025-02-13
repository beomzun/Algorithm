import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int N = citations.length;
        Arrays.sort(citations);
        for(int i=N-1;i>=0;i--) {
            int last=-1;
            if(i!=0) {
                last = citations[i-1];
            }
            for(int h=citations[i];h>last;h--) {
                if(N-i>=h&&i<=h) {
                    return h;
                }
            }
        }
        return 0;
    }
}
/*
발표 논문 수 cit.length
0 1 3 5 6
*/