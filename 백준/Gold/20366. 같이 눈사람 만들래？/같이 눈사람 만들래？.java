import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] snowBalls = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snowBalls[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snowBalls);

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < N - 3; i++) {
            for (int j = N - 1; j >= i + 3; j--) {
                int elsa = snowBalls[i] + snowBalls[j];
                int left = i + 1;
                int right = j - 1;
                while (left < right) {
                    int anna = snowBalls[left] + snowBalls[right];
                    if (anna == elsa) {
                        System.out.println(0);
                        return;
                    }
                    if (anna > elsa) {
                        right--;
                    } else {
                        left++;
                    }
                    minDis = Math.min(minDis, Math.abs(elsa - anna));
                }
            }
        }

        System.out.println(minDis);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
2 3 5 5 9
2 9 5 5
2 5 3 5
내부가 클 때 : 내부오른쪽 줄이기 || 외부 왼쪽 늘리기
내부가 작을 때 : 내부왼쪽 늘리기 || 외부 오른쪽 줄이기
---
항상 최선이 정답은 아닐수도 있구나..?
 */