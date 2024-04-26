import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Job> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Job(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort((j1, j2) -> j1.start == j2.start ? j1.end - j2.end : j1.start - j2.start);
        pq.add(list.get(0).end);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= list.get(i).start) {
                pq.remove();
            }
            pq.add(list.get(i).end);
        }
        bw.write(pq.size() + "");
        bw.flush();
        bw.close();
    }
}
class Job {
    int start;
    int end;

    public Job(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}