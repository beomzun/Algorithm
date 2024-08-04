import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int high = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[high + 1];
        int[] dx = {up, -down};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.remove();
                if (now == target) {
                    System.out.println(time);
                    return;
                }
                for (int j = 0; j < 2; j++) {
                    int next = now + dx[j];
                    if (next > high || next < 1) {
                        continue;
                    }
                    if (!visit[next]) {
                        queue.add(next);
                        visit[next] = true;
                    }
                }
            }
            time++;
        }
        System.out.println("use the stairs");
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
