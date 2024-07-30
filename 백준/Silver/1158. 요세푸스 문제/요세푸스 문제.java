import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        ListIterator<Integer> iter = list.listIterator();

        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!list.isEmpty()) {
            for (int i = 0; i < target; i++) {
                if (iter.hasNext()) {
                    tmp = iter.next();
                } else {
                    iter = list.listIterator(0);
                    if (iter.hasNext()) {
                        tmp = iter.next();
                    }
                }
            }
            iter.remove();
            sb.append(tmp).append(", ");
        }
        
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
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