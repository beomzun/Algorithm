import java.util.*;
import java.io.*;
class Solution {
    int N;
    boolean[] visit;
    StringBuilder sb = new StringBuilder();
    ArrayList<Integer> list = new ArrayList<>();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            visit[i] = true;
            list.add(i);
            dfs(1);
            visit[i] = false;
            list.remove(0);
        }
        
        System.out.println(sb);
    }
    public void dfs(int depth) {
        if(depth==N) {
            for(int val : list) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            list.add(i);
            dfs(depth+1);
            visit[i] = false;
            list.remove(depth);
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

 */