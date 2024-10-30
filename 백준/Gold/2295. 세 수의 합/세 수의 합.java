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
        Arrays.sort(numbers);

        Set<Integer> twoSums = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoSums.add(numbers[i] + numbers[j]);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int target = numbers[i] - numbers[j];
                if (target < 0) {
                    continue;
                }
                if (twoSums.contains(target)) {
                    System.out.println(numbers[i]);
                    return;
                }
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
끝에서부터 target. target보다 작은 수들중 양끝 수들로 투포인터. Set으로 마지막 필요 수 탐색. 없으면 양끝수들중 그 앞에 애들이랑 차이 덜 나는애 옮기기 -> 세 수가 같아도됨
---
입력받은 수들에 대해 두 수의 합을 계산하여 배열로 저장 (A+B) \ twoSums와 numbers에 대해 A+B = K-C의 존재 확인
 */