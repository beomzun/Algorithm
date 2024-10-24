import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long begin = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        long count = 0;
        boolean[] visit = new boolean[(int)Math.sqrt(end) + 2];
        for (int i = 2; i < visit.length; i++) {
            if (!visit[i]) {
                //배수제거
                for (int j = i * 2; j < visit.length; j += i) {
                    visit[j] = true;
                }

                //제곱수탐색
                long val = (long) i * i;
                //범위내의 시작 N제곱 만들기
                while (val < begin) {
                    val *= i;
                }
                //범위내의 N제곱 수 찾기
                while (begin <= val && val <= end) {
                    count++;
                    if (val > end / i) {
                        break;
                    }
                    val *= i;
                }
            }
        }
        System.out.println(count);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
100_000_000_000_000
거의 소수 = 소수^N
단순배수는 걸러야함 => 단순배수 다 거르고, 제곱은 다시 표시
enum : 소수, 배수, 거의 소수
소수 2 : 배수 6 10 12 등은 거르고, 거의 소수 4 8 16은 살려야함.
4 8 9 25
---
배수 다 지우고, 소수는 따로 계산하자.
 */