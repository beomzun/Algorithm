import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] count = new int[11];
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;
        for (int i = 4; i < 11; i++) {
            count[i] = 0;
            for (int j = 1; j <= 3; j++) {
                count[i] += count[i - j];
            }
        }
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(count[n] + "\n");
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
/*
1-1
2-11,2 -> 1+1 2
3-111,12,21,3 -> 1+(11,2) 2+1, 3
4-13,22,31 -> 1+(111,12,21,3) 2+(11,2) + 3+1
5-14,23,32
6-15,24,33
 */
