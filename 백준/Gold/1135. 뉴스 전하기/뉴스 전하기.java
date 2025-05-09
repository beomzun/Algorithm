import java.util.*;
import java.io.*;
class Solution {
    ArrayList<Integer>[] graph;
    int[] childCount;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
        }

        childCount = new int[N];
        int[] parentNum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        parentNum[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++) {
            int parent = Integer.parseInt(st.nextToken());
            graph[parent].add(i);
            while(parent!=-1) {
                childCount[parent]++;
                parent = parentNum[parent];
            }
        }

        System.out.println(dfs(0));
    }
    public int dfs(int now) {
        if(childCount[now]==0) {
            return 0;
        }
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : graph[now]) {
            q.add(dfs(val));
        }
        int count = 1;
        int max = 0;
        while(!q.isEmpty()) {
            max = Math.max(max, q.remove()+count++);
        }
        return max;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
트리구조의 회사에서 모든 직원이 뉴스를 듣는 최소시간.
상사는 자신보다 번호가 작다.
---
여러 자식이 있는 경우 그들의 자식한테 모두 알리는 시간이 오래 걸리는 애부터 전화한다.
타고타고 가면서 자식수를 정립한다. 동시에 부모의 그래프에 자식으로 자신을 등록한다.

 */