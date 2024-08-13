import java.util.*;
import java.io.*;
class Solution {
    static int n;
    static int count = 0;
    static int target;
    static int[] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);
        System.out.println(count = target == 0 ? count - 1 : count);
    }

    public void find(int index, int sum) {
        if (index == n) {
            if (sum == target) {
                count++;
            }
            return;
        }

        find(index + 1, sum);
        find(index + 1, sum + arr[index]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.

과정
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

출력
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.

해결
하나의 tmp 변수만을 사용하여 + - 를 반복하려 했으나 매우 복잡.
---
모든 수의 선택 여부를 재귀를 사용하여 판단 -> 마지막까지 판단한 결과에 따라 count 증가
 */
