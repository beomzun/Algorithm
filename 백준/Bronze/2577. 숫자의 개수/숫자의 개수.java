import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 1;
        int[] arr = new int[10];
        for (int i = 0; i < 3; i++) {
            n *= Integer.parseInt(br.readLine());
        }
        String[] num = String.valueOf(n).split("");
        for (int i = 0; i < num.length; i++) {
            arr[Integer.parseInt(num[i])]++;
        }
        for (int i = 0; i < 10; i++) {
            bw.write(arr[i] + "\n");
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