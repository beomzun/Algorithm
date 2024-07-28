import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        if (list.get(0).equals(list.get(1)) && list.get(1).equals(list.get(2))) {
            bw.write(String.valueOf(10000 + list.get(0) * 1000));
        } else if (list.get(0).equals(list.get(1)) || list.get(1).equals(list.get(2))) {
            bw.write(String.valueOf(1000 + list.get(1) * 100));
        } else {
            bw.write(String.valueOf(list.get(2) * 100));
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
