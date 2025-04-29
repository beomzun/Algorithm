import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i=0;i<N;i++) {
            int now = Integer.parseInt(st.nextToken());
            if(set.contains(M-now)) {
                count++;
                continue;
            }
            set.add(now);
        }
        
        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

