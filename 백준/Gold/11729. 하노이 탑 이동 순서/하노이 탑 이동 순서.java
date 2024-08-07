import java.util.*;
import java.io.*;
class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2, n) - 1 + "\n");
        hanoi(n, 1, 3, 2);
        bw.flush();
        bw.close();
    }

    public void hanoi(int n, int start, int end, int mid) throws IOException {
        if (n == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        hanoi(n - 1, start, mid, end);
        bw.write(start + " " + end + "\n");
        hanoi(n - 1, mid, end, start);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
