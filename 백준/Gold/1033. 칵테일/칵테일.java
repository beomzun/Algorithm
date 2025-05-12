import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] top = new long[N];
        long[] bot = new long[N];
        ArrayList<long[]>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new long[]{b,c,d});
            graph[b].add(new long[]{a,d,c});
        }
        top[0]=1;
        bot[0]=1;

        boolean[] visit = new boolean[N];
        visit[0] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while(!q.isEmpty()) {
            int now = q.remove();
            for(long[] neigh : graph[now]) {
                int num = (int) neigh[0];
                if(visit[num]) {
                    continue;
                }
                visit[num] = true;

                // a/b = c/d -> b = a*d/c
                long nTop = top[now] * neigh[2];
                long nBot = bot[now] * neigh[1];
                long gcd = gcd(nTop, nBot);
                top[num] = nTop/gcd;
                bot[num] = nBot/gcd;

                q.add(num);
            }
        }

        long lcm = 1;
        for(int i=0;i<N;i++) {
            lcm = lcm(lcm, bot[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(top[i] * lcm / bot[i]).append(" ");
        }
        System.out.println(sb);
    }

    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
하나를 1로잡고 시작
---
a,b의 최대공약수 b == 0 ? a : gcd(b, a % b);
a,b의 최소공배수 a / gcd(a, b) * b;
 */