import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N+1];
        int[] parentCount = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int past = Integer.parseInt(st.nextToken());
            if(past==-1) {
                q.add(i);
            }
            while(past!=-1) {
                graph[past].add(i);
                parentCount[i]++;
                past = Integer.parseInt(st.nextToken());
            }
        }

        int[] answer = new int[N+1];
        while(!q.isEmpty()) {
            int now = q.remove();
            answer[now] += times[now];
            for(int child : graph[now]) {
                answer[child] = Math.max(answer[child], answer[now]);
                parentCount[child]--;
                if(parentCount[child]==0) {
                    q.add(child);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(answer[i]).append("\n");
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
/*
위상 정렬

 */