import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            list.add(tmp);
            sum += tmp;
        }
        br.close();

        Collections.sort(list);

        int outA = 0;
        int outB = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int tmp = sum - list.get(i) - list.get(j);
                if (tmp == 100) {
                    outA = i;
                    outB = j;

                    i=10;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != outA && i != outB) {
                bw.write(list.get(i) + "\n");
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
