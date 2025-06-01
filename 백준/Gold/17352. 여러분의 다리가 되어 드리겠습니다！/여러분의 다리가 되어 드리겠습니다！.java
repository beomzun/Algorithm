import java.util.*;
import java.io.*;
class Solution {
    int[] parents;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        for(int i=1;i<=N;i++) {
            parents[i] = i;
        }
        for(int i=0;i<N-2;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int a = find(1);
        for(int i=2;i<=N;i++) {
            if(find(i)!=a) {
                System.out.println(a + " " + find(i));
                return;
            }
        }
    }
    public void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if(pA>pB) {
            parents[pA] = pB;
        } else {
            parents[pB] = pA;
        }
    }
    public int find(int a) {
        if(parents[a]==a) {
            return a;
        }
        return find(parents[a]);
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