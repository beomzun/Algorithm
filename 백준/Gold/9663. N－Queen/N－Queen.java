import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {

    static int count = 0;
    static int[] arr;
    static int n;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nQueen(0);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void nQueen(int col) {
        if (col == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[col] = i;
            if (possible(col)) {
                nQueen(col + 1);
            }
        }
    }

    public static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}