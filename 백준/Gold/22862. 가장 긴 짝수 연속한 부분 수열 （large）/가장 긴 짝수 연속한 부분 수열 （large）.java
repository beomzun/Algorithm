import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int result = 0;
        while (start < N && arr[start] % 2 == 1) {
            start++;
        }
        if (start == N) {
            System.out.println(0);
            return;
        }
        int passCount = 0;
        int count = 0;
        int end = start;
        while (end < N) {
            while (end < N && passCount <= K) {
                if (arr[end] % 2 == 0) {
                    count++;
                } else {
                    passCount++;
                }
                end++;
            }
            result = Math.max(result, count);

            if (end == N) {
                break;
            }

            start++;
            while (start < N) {
                if (arr[start] % 2 == 1) {
                    passCount--;
                    start++;
                } else {
                    count--;
                    break;
                }
            }
            if (start == N) {
                break;
            }
        }

        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
3 1 2
---
221122 처럼 홀수가 연속한 경우 간과
 */