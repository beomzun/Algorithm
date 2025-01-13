import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();
        int count = 0;
        for (int i = 0; i <= s.length() - target.length(); i++) {
            if (s.startsWith(target, i)) {
                count++;
                i += target.length() - 1;
            }
        }

        System.out.println(count);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
