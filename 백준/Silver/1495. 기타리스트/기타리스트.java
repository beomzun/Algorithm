import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);
        for(int i=0;i<N;i++) {
            int size=q.size();
            Set<Integer> set = new HashSet<>();
            while(size-->0) {
                int now = q.remove();

                int next = now+V[i];
                if(next<=M) {
                    if(!set.contains(next)) {
                        set.add(next);
                        q.add(next);
                    }
                }
                next = now-V[i];
                if(next>=0) {
                    if(!set.contains(next)) {
                        set.add(next);
                        q.add(next);
                    }
                }
            }
        }
        int max=-1;
        while(!q.isEmpty()) {
            max = Math.max(max, q.remove());
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
각 곡이 시작하기 전에 조절가능한 음량 - V => 0번 노래 시작전에 v[0]으로 수정해야함.
 */