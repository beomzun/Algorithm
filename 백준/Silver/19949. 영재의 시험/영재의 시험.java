import java.util.*;
import java.io.*;
class Solution {
    int[] answer = new int[10];
    int[] my = new int[10];
    int count = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<10;i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, -1);

        System.out.println(count);
    }
    public void dfs(int depth, int past) {
        if(depth==10) {
            int same = 0;
            for(int i=0;i<10;i++) {
                if(answer[i]==my[i]) {
                    same++;
                }
            }
            if(same>=5) {
                count++;
            }
            return;
        }
        for(int i=1;i<=5;i++) {
            int next = -1;
            if(past>0 && past==i) {
                continue;
            }
            my[depth] = i;
            if(depth>0 && my[depth-1]==i) {
                next = i;
            }
            dfs(depth+1, next);
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
5^10 = 10^10 / 2^10 = 10,000,000
 */
