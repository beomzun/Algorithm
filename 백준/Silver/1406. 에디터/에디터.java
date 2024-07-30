import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        LinkedList<Character> list = new LinkedList<>();

        char[] val = br.readLine().toCharArray();
        for(char c : val) {
            list.add(c);
        }
        ListIterator<Character> iter = list.listIterator(list.size());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            switch (comm) {
                case "P":
                    char c = st.nextToken().charAt(0);
                    iter.add(c);
                    break;
                case "L":
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case "D":
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case "B":
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }

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
