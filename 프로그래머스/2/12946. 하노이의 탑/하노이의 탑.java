class Solution {
    int[][] answer;
    int idx=0;
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2,n)-1][2];
        
        hanoi(n,1,2,3);
        
        return answer;
    }
    
    public void hanoi(int n, int start, int mid, int end) {
        if(n==1) {
            move(start,end);
            return;
        }
        hanoi(n-1, start,end,mid);
        
        move(start,end);
        
        hanoi(n-1,mid,start,end);
    }
    public void move(int from, int to) {
        answer[idx][0] = from;
        answer[idx][1] = to;
        idx++;
    }
}