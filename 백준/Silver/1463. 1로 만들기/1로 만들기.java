import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        arr[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                arr[i] = Math.min(Math.min(arr[i / 3], arr[i / 2]), arr[i - 1]) + 1;
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }
        bw.write(String.valueOf(arr[n]));
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