import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer>[] points = new PriorityQueue[200001];
        for (int i = 0; i < 200001; i++) {
            points[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 100000;
            int y = Integer.parseInt(st.nextToken());
            points[x].add(y);
        }

        int result = 0;
        for (int i = 0; i < 200001; i++) {
            while (!points[i].isEmpty()) {
                bw.write((i - 100000) + " " + points[i].remove() + "\n");
                result++;
            }
            if (result == n) {
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
