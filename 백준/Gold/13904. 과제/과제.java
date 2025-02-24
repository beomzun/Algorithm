import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<int[]> assigns = new PriorityQueue<>((o1,o2)->o2[0]-o1[0]);
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            assigns.add(new int[]{d,w});
        }

        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int lastD = assigns.peek()[0];
        while(!assigns.isEmpty()) {
            int nowD = assigns.peek()[0];
            while(!q.isEmpty() && nowD+1 < lastD) {
                answer+=q.remove();
                lastD--;
            }
            lastD = nowD;
            while(!assigns.isEmpty() && assigns.peek()[0]==nowD) {
                q.add(assigns.remove()[1]);
            }
            answer += q.remove();
        }
        lastD--;
        while(!q.isEmpty() && lastD-->0) {
            answer +=q.remove();
        }
        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
기간 긴 순 / 점수 높은 순
 */