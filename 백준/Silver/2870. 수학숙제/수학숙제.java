import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String> q = new PriorityQueue<>((s1,s2)-> {
            if(s1.length()==s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                    continue;
                }
                int k;
                for (k = j; k < s.length(); k++) {
                    if (s.charAt(k) >= '0' && s.charAt(k) <= '9') {
                        continue;
                    }
                    break;
                }

                String input = s.substring(j, k);
                int zeroIdx;
                for (zeroIdx = 0; zeroIdx < input.length(); zeroIdx++) {
                    if (input.charAt(zeroIdx) == '0') {
                        continue;
                    }
                    break;
                }
                input = input.substring(zeroIdx);
                if (input.isEmpty()) {
                    input = "0";
                }
                q.add(input);
                j = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(q.remove()).append("\n");
        }
        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
