import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        int build = Integer.parseInt(st.nextToken());
        int way = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < now; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.add(0);
        list.add(way);
        Collections.sort(list);

        int left = 1;
        int right = way;
        int count, mid, res = 0;
        while (left <= right) {
            count = 0;
            mid = (left + right) / 2;
            for (int i = 1; i < now + 2; i++) {
                count += (list.get(i) - list.get(i - 1) - 1) / mid;
            }
            if (count <= build) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        bw.write(res + "");
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