import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] room = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = i; j <= N; j += i) {
                    room[j] = !room[j];
                }
            }
            int count = 0;
            for (boolean b : room) {
                if(b) count++;
            }
            bw.write(count + "\n");
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
