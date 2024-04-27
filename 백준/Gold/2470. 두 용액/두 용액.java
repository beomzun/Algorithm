import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int start = 0, end = n - 1, sum;
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];

        while (start < end) {
            sum = list.get(start) + list.get(end);
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                res[0] = list.get(start);
                res[1] = list.get(end);
                if (sum == 0) {
                    break;
                }
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        bw.write(res[0] + " " + res[1]);
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