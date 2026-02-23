class Solution {
    int answer=0;
    int n;
    int[] arr;
    public int solution(int n) {
        this.n=n;
        arr = new int[n];
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int col) {
        if(col==n) {
            answer++;
            return;
        }
        
        // 이전 열들에 현재 행을 사용했는지
        for(int i=0;i<n;i++) {
            boolean used = false;
            for(int j=0;j<col;j++) {
                if(arr[j]==i || Math.abs(col-j)==Math.abs(i-arr[j])) {
                    used = true;
                    break;
                }
            }
            if(used) {
                continue;
            }
            arr[col]=i;
            
            dfs(col+1);
        }
    }
}
// 해당 열에는 몇번째 행에 위치하는가