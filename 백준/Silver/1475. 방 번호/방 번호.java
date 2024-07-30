import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.MIN_VALUE;
        int[] arr = new int[10];
        char[] val = br.readLine().toCharArray();
        for(char c : val) {
            int tmp = Character.getNumericValue(c);
            if (tmp == 6 || tmp == 9) {
                tmp = arr[6] > arr[9] ? 9 : 6;
            }
            arr[tmp]++;
            max = Math.max(max, arr[tmp]);
        }

        bw.write(max + "");
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
