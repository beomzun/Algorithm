import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] used = new int[27];

        char[] a = br.readLine().toCharArray();
        for(char charA : a) {
            used[charA-'a']++;
        }
        char[] b = br.readLine().toCharArray();
        for(char charB : b) {
            used[charB-'a']--;
        }

        int count = 0;
        for (int i = 0; i < 27; i++) {
            count += Math.abs(used[i]);
        }

        bw.write(count + "");
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
