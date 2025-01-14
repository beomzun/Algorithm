import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        char[] dna = new char[]{'A', 'C', 'G', 'T'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int max = 0;
            int maxIdx = 0;
            for (int j = 0; j < 4; j++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (dna[j] == arr[k].charAt(i)) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    maxIdx = j;
                }
            }
            sb.append(dna[maxIdx]);
        }

        String answer = sb.toString();
        int hd = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (answer.charAt(j) != arr[i].charAt(j)) {
                    hd++;
                }
            }
        }

        System.out.println(answer + "\n" + hd);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
