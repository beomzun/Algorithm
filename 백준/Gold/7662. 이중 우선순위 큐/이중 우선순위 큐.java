import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());
                switch (c) {
                    case 'I':
                        map.put(value, map.getOrDefault(value, 0) + 1);
                        break;
                    case 'D':
                        if (map.isEmpty()) {
                            break;
                        } else {
                            if (value == 1) {
                                int key = map.lastKey();
                                int kvalue = map.get(key);
                                if (kvalue == 1) {
                                    map.remove(key);
                                } else {
                                    map.put(key, kvalue - 1);
                                }
                            } else {
                                int key = map.firstKey();
                                int kvalue = map.get(key);
                                if (kvalue == 1) {
                                    map.remove(key);
                                } else {
                                    map.put(key, kvalue - 1);
                                }
                            }
                        }
                        break;
                }
            }
            if (map.isEmpty()) {
                bw.write("EMPTY");
            } else {
                bw.write(String.valueOf(map.lastKey()));
                bw.write(" ");
                bw.write(String.valueOf(map.firstKey()));
            }
            bw.write("\n");
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