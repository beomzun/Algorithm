import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp % 2 == 1) {
                list.add(tmp);
                sum += tmp;
            }
        }

        if(list.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);

        bw.write(sum + "\n");
        bw.write(String.valueOf(list.get(0)));
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
