import java.util.*;
import java.io.*;
class Solution {
    boolean[] visit;
    int length = 0;
    String[] numS;
    TreeSet<Integer> set = new TreeSet<>();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        length = num.length();
        int N = Integer.parseInt(num);
        visit = new boolean[length];
        numS = new String[length];
        int base = N;
        for(int i=0;i<length;i++) {
            numS[i] = String.valueOf(base%10);
            base/=10;
        }
        for(int i=0;i<length;i++) {
            visit[i] = true;
            dfs(1,numS[i]);
            visit[i] = false;
        }

        set.remove(N);
        if(set.ceiling(N)==null) {
            System.out.println(0);
        } else {
            System.out.println(set.ceiling(N));
        }
    }

    public void dfs(int depth, String now) {
        if(depth==length) {
            set.add(Integer.parseInt(now));
        }
        for(int i=0;i<length;i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(depth+1, now+numS[i]);
            visit[i] = false;
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

