import java.util.*;
import java.io.*;
class Solution {

    int[] writingCount = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name1.length(); i++) {
            sb.append(writingCount[name1.charAt(i)-'A']).append(writingCount[name2.charAt(i)-'A']);
        }
        String encoded = sb.toString();
        while (encoded.length() != 2) {
            sb = new StringBuilder();
            for (int i = 0; i < encoded.length() - 1; i++) {
                int pre = Character.getNumericValue(encoded.charAt(i));
                int post = Character.getNumericValue(encoded.charAt(i + 1));
                sb.append((pre + post) % 10);
            }
            encoded = sb.toString();
        }

        System.out.println(encoded);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
