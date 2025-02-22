import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][3];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
            lectures[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lectures, (o1,o2)->o1[1]-o2[1]);

        int max = 0;
        Queue<Integer> q = new PriorityQueue<>();
        for(int[] lecture : lectures) {
            if(q.isEmpty()) {
                q.add(lecture[2]);
                max = Math.max(max,1);
                continue;
            }
            while(!q.isEmpty()) {
                if(lecture[1]>=q.peek()) {
                    q.remove();
                    continue;
                }
                q.add(lecture[2]);
                break;
            }
            max = Math.max(max,q.size());
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
