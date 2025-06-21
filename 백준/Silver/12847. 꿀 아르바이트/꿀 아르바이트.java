import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
        }

        long max = 0L;
        for(int i=M;i<=N;i++) {
            max = Math.max(max, arr[i] - arr[i - M]);
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
전체 n일 중 일할수 있는 날 m일
n일간 각 일급 t원
연속으로 일해야함.
 */