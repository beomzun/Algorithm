import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[] fill = new boolean[10001];
        int sum = 0;
        ArrayList<Job> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Job(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort((j1, j2) -> j1.pay == j2.pay ? j2.deadLine - j1.deadLine : j2.pay - j1.pay);
        for (Job j : list) {
            int date = j.deadLine;
            while (date > 0) {
                if (!fill[date]) {
                    fill[date] = true;
                    sum += j.pay;
                    break;
                } else {
                    date--;
                }
            }
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
class Job {
    int pay;
    int deadLine;

    public Job(int pay, int deadLine) {
        this.pay = pay;
        this.deadLine = deadLine;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}