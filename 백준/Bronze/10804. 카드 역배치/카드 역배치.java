import java.util.*;
import java.io.*;

class O_Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] arr = new int[21];
        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j = s; j <= e; j++) {
                stack.add(arr[j]);
            }
            for (int j = s; j <= e; j++) {
                arr[j] = stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 21; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);

    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        O_Solution s = new O_Solution();
        s.solution();
    }
}
