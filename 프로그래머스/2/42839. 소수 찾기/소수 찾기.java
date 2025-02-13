import java.util.*;
class Solution {
    boolean[] visit;
    Set<Integer> set = new HashSet<>();     //만든 소수
    Set<Integer> prior = new HashSet<>();   //전체 소수
    int N;
    Integer[] numbers;
    public int solution(String nums) {
        N = nums.length();
        numbers = new Integer[N];
        for(int i=0;i<N;i++) {
            numbers[i] = Character.getNumericValue(nums.charAt(i));
        }
        Arrays.sort(numbers,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int val : numbers) {
            sb.append(val);
        }
        int max = Integer.parseInt(sb.toString());
        boolean[] normal = new boolean[max+1];
        normal[0]=normal[1]=true;
        
        //소수구하기 
        for(int i=2;i<=max;i++) {
            if(!normal[i]) {
                prior.add(i);
            }
            for(int j=i*2;j<=max;j+=i) {
                normal[j]=true;
            }
        }
        
        visit = new boolean[N];
        //몇개 선택할건지
        for(int i=1;i<=N;i++) {
            dfs(i,0,"");
        }
        
        return set.size();
    }
    
    public void dfs(int depth, int nowD, String val) {
        if(nowD==depth) {
            int iVal = Integer.parseInt(val);
            if(prior.contains(iVal)) {
                set.add(iVal);
            }
            return;    
        }
        for(int i=0;i<N;i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(depth,nowD+1,val+numbers[i]);
            visit[i] = false;
        }
    }
}
/*
다 안써도댐
*/