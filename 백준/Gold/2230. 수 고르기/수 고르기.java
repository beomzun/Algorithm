import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        int left = 0;
        int right = 0;
        int minDif = Integer.MAX_VALUE;
        while (right < N) {
            int dif = numbers[right] - numbers[left];
            if (dif == M) {
                System.out.println(M);
                return;
            }
            if (dif > M) {
                minDif = Math.min(minDif, dif);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(minDif);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
첫 방식은 왼쪽이 움직였을때 오른쪽 움직임을 확인하지않고 왼쪽이 움직였을때 더 작다고 강제하는 오류
---
투 포인터를 한쪽에서 시작.
 */