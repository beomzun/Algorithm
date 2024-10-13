import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] winner = new boolean[N + 1];
        if (N < 5) {
            if (N == 2) {
                System.out.println("CY");
            } else {
                System.out.println("SK");
            }
            return;
        }
        winner[4] = winner[3] = winner[1] = true;
        for (int i = 5; i <= N; i++) {
            winner[i] = !(winner[i - 1] && winner[i - 3] && winner[i - 4]);
        }
        System.out.println(winner[N] ? "SK" : "CY");
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1,3,4개 뺀것의 결과가 모두 같으면 패배
 */