import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int K;
    static int answer = 0;
    static int[] gyms;
    static boolean[] used;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        gyms = new int[N];
        used = new boolean[N];
        for(int i=0;i<N;i++) {
            gyms[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++) {
            used[i]=true;
            dfs(1, i, 500);
            used[i] = false;
        }

        System.out.println(answer);
    }
    public static void dfs(int depth, int num, int now) {
        now+=gyms[num];
        now-=K;
        if(now<500) {
            return;
        }

        if(depth==N) {
            answer++;
            return;
        }

        for(int i=0;i<N;i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            dfs(depth+1, i, now);
            used[i] = false;
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