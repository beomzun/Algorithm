import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] students = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int grade = Integer.parseInt(st.nextToken());
            students[i] = grade;
        }
        Arrays.sort(students);

        long result = 0;
        for (int i = 0; i < N - 2; i++) {
            if (students[i] > 0) {
                break;
            }

            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                int sum = students[i] + students[start] + students[end];
                if (sum == 0) {
                    if (students[start] == students[end]) {
                        result += (long)(end - start + 1) * (end - start) / 2;
                        break;
                    }
                    int lc = 1;
                    while (students[start] == students[start + 1]) {
                        start++;
                        lc++;
                    }
                    int rc = 1;
                    while (students[end] == students[end - 1]) {
                        end--;
                        rc++;
                    }
                    result += (long)lc * rc;
                }
                if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
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
000이거나
-n-n 2n 이거나
-2n n n 이거나
---
처음엔 양쪽 픽스하고 가운데 찾기 하려했으나 중복 찾아내기가 어려워 거꾸로하엿음
---
0이 10000개면 10000C3
 */