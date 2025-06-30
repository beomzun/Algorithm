import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Long> q = new ArrayDeque<>();
        for(int i=0;i<N;i++) {
            q.add(Long.parseLong(st.nextToken()));
        }

        long ans = 0L;
        while (q.size() > 1) {
            long a = q.remove();
            long b = q.remove();
            ans += a*b;
            q.add(a + b);
        }

        System.out.println(ans);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
두 슬라임을 합치면 크기는 x+y, 얻는 점수는 x*y
하나 남으면 끝. 최대 점수를 구하라
a b c
a*b + (a+b)*c
a*c + (a+c)*b
b*c + (b+c)*a
 */