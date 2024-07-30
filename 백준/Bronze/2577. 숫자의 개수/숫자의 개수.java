import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        char[] val = String.valueOf(a * b * c).toCharArray();

        int[] arr = new int[10];
        for (char tmp : val) {
            arr[Character.getNumericValue(tmp)]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int tmp : arr) {
            sb.append(tmp).append("\n");
        }

        bw.write(sb.toString());
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
