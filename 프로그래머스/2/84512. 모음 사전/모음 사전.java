import java.util.*;
class Solution {
    int count=0;
    String target="";
    String[] arr = {"A","E","I","O","U"};
    boolean flag=false;
    public int solution(String word) {
        target = word;
        for(int i=0;i<5;i++) {
            dfs(1,i, "");
            if(flag) {
                break;
            }
        }
        return count;
    }
    public void dfs(int depth, int idx, String s) {
        String now = s+arr[idx];
        count++;
        if(now.equals(target)) {
            flag = true;
            return;
        }
        if(depth==5) {
            return;
        }
        for(int i=0;i<5;i++) {
            dfs(depth+1,i, now);
            if(flag) {
                return;
            }
        }
    }
}
/*

*/