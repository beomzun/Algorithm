import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int max = 0;
        for(int i=0;i<N;i++) {
            int val = Integer.parseInt(st.nextToken());
            if(set.isEmpty() || set.ceiling(val)==null) {
                set.add(val);
                max = Math.max(max, set.size());
                continue;
            }
            if(set.ceiling(val)!=null) {
                set.remove(set.ceiling(val));
                set.add(val);
                max = Math.max(max, set.size());
            }
        }

        System.out.println(N-set.size());
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

