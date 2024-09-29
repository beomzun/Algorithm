import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        long[] count = new long[s.length() + 1];
        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        count[0] = count[1] = 1;
        for (int i = 2; i <= length; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
                    System.out.println(0);
                    return;
                }
                count[i] = count[i - 2] % 1000000;
            } else {
                int val = Integer.parseInt(s.substring(i - 2, i));
                if (val > 9 && val < 27) {
                    count[i] = (count[i - 1] + count[i - 2]) % 1000000;
                } else {
                    count[i] = count[i - 1] % 1000000;
                }
            }
        }

        System.out.println(count[length] % 1000000);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
25114
2 5 1 1 4
25 1 1 4
25 11 4
25 1 14
2 5 11 4
2 5 1 14

현재가능수
- 현재 0인 경우
    - 한칸이전이 1,2가 아닌경우 -> 잘못됨
    - 한칸이전이 1,2인 경우 -> 두칸이전수(묶어야하기때문)
- 현재 1~6인 경우
    - 한칸이전이 0인경우 -> 한칸이전수
    - 한칸이전이 1,2인 경우 -> 두칸이전수(묶은경우) + 한칸이전수
    - 한칸이전이 3~ -> 한칸이전수
- 현재 7~9인 경우
    - 넘어온수
---
0 포함하는 경우 분류 후, 두개씩 뜯어서 두 가지로 해석가능한 11~26 처리
 */