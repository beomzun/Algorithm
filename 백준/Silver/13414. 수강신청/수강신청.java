import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        String[] orders = new String[500_001];
        Map<String, Integer> ids = new HashMap<>();

        int count = 0;
        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            int now = ids.getOrDefault(id, -1);
            if (now != -1) {
                orders[now] = "";
            }
            ids.put(id, count);
            orders[count++] = id;
        }

        count = 0;
        for (int i = 0; i < L; i++) {
            String id = orders[i];
            if (!id.isEmpty()) {
                bw.write(id + "\n");
                count++;
            }
            if (count == K) {
                break;
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
