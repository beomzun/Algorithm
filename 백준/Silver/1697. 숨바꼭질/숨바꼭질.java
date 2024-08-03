import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(s, 0);
        queue.add(s);

        int tmp = 0;
        int result = 0;
        boolean out = false;
        if (s == target) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()) {
            int now = queue.remove();
            int val = map.get(now);
            for (int i = 0; i < 3; i++) {
                tmp = switch (i) {
                    case 0 -> now + 1;
                    case 1 -> now - 1;
                    case 2 -> now * 2;
                    default -> tmp;
                };

                if (tmp > 200000) {
                    continue;
                }
                if (tmp == target) {
                    out = true;
                    result = val + 1;
                    break;
                }
                if (!map.containsKey(tmp)) {
                    map.put(tmp, val + 1);
                    queue.add(tmp);
                }
            }
            if (out) {
                break;
            }
        }
        bw.write(result + "");
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