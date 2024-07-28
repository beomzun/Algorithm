import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sum += tmp;
            list.add(tmp);
        }
        Collections.sort(list);

        bw.write(sum / 5 + "\n");
        bw.write(list.get(2) + "");
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
