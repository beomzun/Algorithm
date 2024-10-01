import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        //0 행은 내 앞숫자 인덱스
        int[][] dp = new int[2][N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int maxIdx = 0;
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    if (dp[1][j] + 1 > dp[1][i]) {
                        dp[1][i] = dp[1][j] + 1;
                        dp[0][i] = j;
                        if (dp[1][i] > max) {
                            maxIdx = i;
                            max = dp[1][i];
                        }
                    }
                }
            }
        }

        bw.write(max + "\n");
        Stack<Integer> sortStack = new Stack<>();
        while (maxIdx != -1) {
            sortStack.add(numbers[maxIdx]);
            maxIdx = dp[0][maxIdx];
        }
        while (!sortStack.isEmpty()) {
            bw.write(sortStack.pop() + " ");
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
13
3 4 5 6 2 3 1 7 4 3 5 6 7
 */