import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int val = Integer.parseInt(st.nextToken());
            Integer ceil = set.ceiling(val);
            if(ceil!=null) {
                set.remove(ceil);
            }
            set.add(val);
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
/*
매번 이전값과 비교하는 그리디 -> 반례 2 4 1 3
N-최대증가수열로.
 */