import java.util.*;
import java.io.*;
class Solution {
    int[] parents;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                char c = s.charAt(j);
                if (c == '0') {
                    continue;
                }
                int len = translate(c);
                q.add(new int[]{len, i, j});
            }
        }

        parents = new int[N];
        for(int i=0;i<N;i++) {
            parents[i] = i;
        }

        int rest = 0;
        while (!q.isEmpty()) {
            int[] lan = q.remove();
            int a = lan[1];
            int b = lan[2];
            if (find(a)==find(b)) {
                rest += lan[0];
                continue;
            }
            union(a, b);
        }

        int base = find(0);
        for(int i=1;i<N;i++) {
            if (base != find(i)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(rest);
    }

    public int translate(char c) {
        if(c<'a') {
            return c - 'A' + 27;
        }
        return c - 'a' + 1;
    }
    public int find(int a) {
        if(parents[a]==a) {
            return a;
        }
        return find(parents[a]);
    }
    public void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if(pA<pB) {
            parents[pB] = pA;
        } else {
            parents[pA] = pB;
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
N개의 방에 컴퓨터 하나씩 있음. 각 컴퓨터는 랜선으로 연결되어있음.
모든 컴퓨터를 연결시키는 최단거리의 랜선말고 다 기부하려고하는데 기부가능한 최대 랜선
a-z : 1-26 / A-Z 27-52
모든 컴퓨터 연결이 안되면 -1
---
A = 65 B 66
a = 97 b 98
---
하나일때 , 그래프 반으로 쪼개질떄
 */