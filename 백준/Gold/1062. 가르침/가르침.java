import java.util.*;
import java.io.*;
class Solution {
    int N;
    int K;
    Set<Integer>[] sets;
    boolean[] visit;
    int max = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K<5) {
            System.out.println(0);
            return;
        }
        sets = new HashSet[N];
        for(int i=0;i<N;i++) {
            sets[i] = new HashSet<>();
            String s = br.readLine();
            for(int j=0;j<s.length();j++) {
                sets[i].add(s.charAt(j)-'a');
            }
        }

        visit = new boolean[26];
        visit[0]=visit[2]=visit[8]=visit[13]=visit[19]=true;
        if(K==5) {
            dfs(5,0);
            System.out.println(max);
            return;
        }

        for(int i=0;i<26;i++) {
            if (visit[i]) {
                continue;
            }
            visit[i]=true;
            dfs(6,i);
            visit[i]=false;
        }

        System.out.println(max);
    }
    public void dfs(int depth, int idx) {
        if(depth==K) {
            int count=0;
            for(Set<Integer> set : sets) {
                boolean include = true;
                for(int k : set) {
                    if(!visit[k]) {
                        include=false;
                        break;
                    }
                }
                if(include) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for(int i=idx+1;i<26;i++) {
            if (visit[i]) {
                continue;
            }
            visit[i]=true;
            dfs(depth+1,i);
            visit[i]=false;
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
anta - tica : a,c,t,i,n
 */