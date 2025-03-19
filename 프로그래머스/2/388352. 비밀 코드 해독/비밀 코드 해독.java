class Solution {
    int N;
    int answer = 0;
    int m;
    public int solution(int n, int[][] q, int[] ans) {
        N=n;
        m = q.length;
        int[] code = new int[5];
        dfs(0, code, 1, q, ans);
        return answer;
    }
    public void dfs(int depth, int[] code, int last, int[][] q, int[] ans) {
        if(depth==5) {
            check(code, q, ans);
            return;
        }
        for(int i=last;i<=N;i++) {
            code[depth]=i;
            dfs(depth+1, code, i+1, q, ans);
        }
    }
    public void check(int[] code, int[][] q, int[] ans) {
        boolean good = true;
        for(int i=0;i<m;i++) {
            int count=0;
            for(int j=0;j<5;j++) {
                for(int k=0;k<5;k++) {
                    if(code[j]==q[i][k]) {
                        count++;
                        break;
                    }
                }
            }
            if(count!=ans[i]) {
                good = false;
                break;
            }
        }
        if(good) {
            answer++;
        }
    }
}
/*
n<30
30C5 = 24,300,000

*/