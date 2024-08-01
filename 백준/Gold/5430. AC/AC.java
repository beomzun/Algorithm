import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Deque<Integer> deque = new LinkedList<>();

            String comm = br.readLine();
            int size = Integer.parseInt(br.readLine());

            String s = br.readLine();
            String[] target = s.substring(1, s.length() - 1).split(",");
            if(!target[0].isEmpty()) {
                for(String num : target) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean desc = false;
            boolean error = false;
            for (int j = 0; j < comm.length(); j++) {
                if (comm.charAt(j) == 'R') {
                    desc = !desc;
                } else if(deque.isEmpty()) {
                    error = true;
                    break;
                } else if (!desc) {
                    deque.remove();
                } else {
                    deque.removeLast();
                }
            }

            StringBuilder sb = new StringBuilder();
            if(!deque.isEmpty()) {
                sb.append("[");
                while(!deque.isEmpty()) {
                    if (desc) {
                        sb.append(deque.removeLast() + ",");
                    } else {
                        sb.append(deque.remove() + ",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("]\n");
            } else {
                if (error) {
                    sb.append("error\n");
                } else {
                    sb.append("[]\n");
                }
            }
            bw.write(sb.toString());
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