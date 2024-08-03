import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        visit[s] = true;
        queue.add(s);

        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int val = queue.remove();
                if (val == target) {
                    System.out.println(time);
                }
                if (val + 1 <= 100000 && !visit[val + 1]) {
                    visit[val + 1] = true;
                    queue.add(val+1);
                }
                if (val - 1 >= 0 && !visit[val - 1]) {
                    visit[val - 1] = true;
                    queue.add(val - 1);
                }
                if (val * 2 <= 100000 && !visit[val * 2]) {
                    visit[val*2] = true;
                    queue.add(val * 2);
                }
            }
            time++;
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}