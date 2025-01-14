import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int R = 1;
        for (int i = 1; i <= Math.sqrt(s.length()); i++) {
            if (s.length() % i == 0) {
                R = i;
            }
        }
        int C = s.length() / R;

        char[][] encoded = new char[R][C];
        int idx = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                encoded[j][i] = s.charAt(idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(encoded[i][j]);
            }
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
/*
k a k
o s i
 */