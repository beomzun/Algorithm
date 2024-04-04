import java.io.*;
import java.util.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> rQ = new PriorityQueue<>();
        PriorityQueue<Integer> lQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (lQ.isEmpty()) {
                lQ.add(value);
                bw.write(String.valueOf(value));
            } else if (rQ.isEmpty()) {
                if (value >= lQ.element()) {
                    rQ.add(value);
                    bw.write(String.valueOf(lQ.element()));
                } else {
                    rQ.add(lQ.remove());
                    lQ.add(value);
                    bw.write(String.valueOf(value));
                }
            } else {
                if (lQ.size() > rQ.size()) {
                    if (value < lQ.element()) {
                        rQ.add(lQ.remove());
                        lQ.add(value);
                        bw.write(String.valueOf(lQ.element()));
                    } else {
                        rQ.add(value);
                        bw.write(String.valueOf(lQ.element()));
                    }
                } else if (lQ.size() == rQ.size()) {
                    if (value <= rQ.element()) {
                       lQ.add(value);
                        bw.write(String.valueOf(lQ.element()));
                    } else {
                        rQ.add(value);
                        lQ.add(rQ.remove());
                        bw.write(String.valueOf(lQ.element()));
                    }
                }
            }
            bw.write("\n");
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