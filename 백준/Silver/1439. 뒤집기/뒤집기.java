import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 1;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            count = s.charAt(i) != last ? count + 1 : count;
            last = s.charAt(i);
        }
        System.out.println(count / 2);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
