class Solution {
    public int solution(int storey) {
        int count=0;
        while(storey!=0) {
            int last = storey%10;
            storey/=10;
            
            if(last==5) {
                count+=5;
                if(storey%10>=5) {
                    storey++;
                }
            } else if(last<5) {
                count+=last;
            } else {
                count+=(10-last);
                storey++;
            }
        }
        return count;
    }
}