import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                boolean link = Integer.parseInt(st.nextToken())==1;
                if(link) {
                    graph[i].add(j);
                }
            }
        }

        int[] group = new int[N+1];
        int num = 1;
        for(int i=1;i<=N;i++) {
            if(group[i]!=0) {
                continue;
            }
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            group[i]=num;
            while(!q.isEmpty()) {
                int now = q.remove();
                for(int neigh : graph[now]) {
                    if(group[neigh]==0) {
                        q.add(neigh);
                        group[neigh]=num;
                    }
                }
            }
            num++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int groupNum = group[Integer.parseInt(st.nextToken())];
        for(int i=1;i<M;i++) {
            if(group[Integer.parseInt(st.nextToken())]!=groupNum) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

