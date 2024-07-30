import java.util.*;
import java.io.*;

class O_Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int start = 0;
        int end = size - 1;
        int count = 0;
        while (start < end) {
            int left = list.get(start);
            int right = list.get(end);
            int sum = left + right;
            if (sum < x) {
                start++;
            } else if (sum > x) {
                end--;
            } else {
                count++;
                start++;
                end--;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        O_Solution s = new O_Solution();
        s.solution();
    }
}
