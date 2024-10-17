import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(numbers[0]);
            return;
        }
        Arrays.sort(numbers);

        long result = 0;
        int right = N - 1;
        //양수 처리
        for (; right >= 1 && numbers[right] > 0; right--) {
            if (numbers[right - 1] > 0 && numbers[right - 1] > 1) {
                result += (long) numbers[right] * numbers[right - 1];
                right--;
                continue;
            }
            result += numbers[right];
        }
        if (right == 0 && numbers[right] > 0) {
            result += numbers[right];
        }

        //음수 처리
        int left = 0;
        for (; left < N - 1 && numbers[left] < 0; left++) {
            if (numbers[left + 1] < 0) {
                result += (long) numbers[left] * numbers[left + 1];
                left++;
                continue;
            }
            //끝이 아닌 마지막 음수
            if (numbers[left + 1] != 0) {
                result += numbers[left];
                break;
            }
        }
        if (left == N - 1 && numbers[left] < 0) {
            result += numbers[left];
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
N<50
-1000~1000
한번만 묶거나 묶지 않거나
---
단순 오름차순인경우 -6 -4 -4 인경우 오답처리됨.
---
-1 1 2 인 경우 2+1>2*1
 */