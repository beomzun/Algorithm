import java.util.*;
import java.io.*;

class Solution {

    static int count = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Z(size, r, c);
        System.out.println(count);
    }

    public void Z(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        if (r < size / 2 && c < size / 2) {
            Z(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            count += size * size / 4;
            Z(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) {
            count += size * size / 2;
            Z(size / 2, r - size / 2, c);
        } else {
            count += size * size / 4 * 3;
            Z(size / 2, r - size / 2, c - size / 2);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
