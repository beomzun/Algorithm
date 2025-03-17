import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        int[] count = new int[N+1];
        int[] rank = new int[N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            count[b]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
            if(count[i]==0) {
                q.add(i);
                rank[i] = 1;
            }
        }

        int time=2;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int now = q.remove();
                for(int val : graph[now]) {
                    count[val]--;
                    if(count[val]==0) {
                        rank[val]=time;
                        q.add(val);
                    }
                }
            }
            time++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}