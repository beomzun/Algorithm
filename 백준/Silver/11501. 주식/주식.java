import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long earning = 0;
            int max = prices[N - 1];
            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] >= max) {
                    max = prices[i];
                    continue;
                }
                earning += (max - prices[i]);
            }
            bw.write(earning + "\n");
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
10 7 6 -> 하락장. 이익 0
3 5 9 -> 불장. 드가자~
1 1 3 1 2 -> 단타.
1 1 4 3 2 3 4
< max 사고, >= 안하고, // 팔아
---
long
 */