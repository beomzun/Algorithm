import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(N);i++) {
            if(N%i==0) {
                int plus = N/i; //a+b
                int minus = N/plus; //a-b
                if((plus+minus)%2!=0 || plus-minus==0) {
                    continue;
                }
                list.add((plus + minus) / 2);
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int a : list) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
G킬로그램 = 현재 몸무게의 제곱에서 성원이가 기억하고 있던 몸무게의 제곱을 뺀 값
현재 몸무게로 가능한 것을 모두 출력하는 프로그램
G=15 => 현재 제곱 - 15 = 제곱수
16 - 15 = 1
    (4+1)(4-1) = 15
64 - 15 = 49
    (8+7)(8-7) = 15
a>b 이고 (a+b)(a-b) = G인 경우
G를 소인수분해해서 a,b 구하기
---
15라면
1,15
3,5
a+b = 15 \ a-b = 1 => a=8
a+b=5 \ a-b  3 => a=4
 */