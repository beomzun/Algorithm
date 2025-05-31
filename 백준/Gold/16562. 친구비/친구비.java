import java.util.*;
import java.io.*;
class Solution {
    int[] parents;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prices = new int[N+1];
        for(int i=1;i<=N;i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        parents = new int[N+1];
        for(int i=1;i<=N;i++) {
            parents[i] = i;
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        //없으면 넣고 있으면 비교
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<=N;i++) {
            int group = find(parents[i]);
            map.put(group, Math.min(prices[i], map.getOrDefault(group, 10001)));
        }

        int sum = 0;
        for(int group : map.keySet()) {
            sum+=map.get(group);
        }

        if(sum<=K) {
            System.out.println(sum);
            return;
        }
        System.out.println("Oh no");
    }
    public void union(int a, int b) {
        int pA = find(parents[a]);
        int pB = find(parents[b]);
        //작은번호가 팀장
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