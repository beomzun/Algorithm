import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m;
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (Math.abs(o1) == Math.abs(o2)) {
                            if (o1 < o2) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } else {
                            return Math.abs(o1) - Math.abs(o2);
                        }
                    }
                }
        );
        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            if (m == 0) {
                if (queue.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(queue.remove() + "\n");
                }
            } else {
                queue.add(m);
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