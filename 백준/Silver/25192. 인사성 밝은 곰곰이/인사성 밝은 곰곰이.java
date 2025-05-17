import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<N;i++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                count+=set.size();
                set = new HashSet<>();
            } else {
                set.add(chat);
            }
        }

        count+=set.size();
        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

