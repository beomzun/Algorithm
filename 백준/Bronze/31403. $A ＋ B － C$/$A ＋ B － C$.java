import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        bw.write(a + b - c + "\n");
        bw.write(Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c + "");
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
