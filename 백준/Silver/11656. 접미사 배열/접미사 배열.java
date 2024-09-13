import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        PriorityQueue<String> strings = new PriorityQueue<>(String::compareTo);

        for (int i = 0; i < s.length(); i++) {
            strings.add(s.substring(i));
        }

        while(!strings.isEmpty()) {
            bw.write(strings.remove() + "\n");
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
