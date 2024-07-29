import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[21];
        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Pair(start, end));
        }

        for(Pair pair : list) {
            int start = pair.start;
            int end = pair.end;
            while (start < end) {
                int tmp = arr[start];
                arr[start]=arr[end];
                arr[end] = tmp;

                start++;
                end--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 21; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
