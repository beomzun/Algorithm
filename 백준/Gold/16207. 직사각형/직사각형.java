import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        long answer = 0;
        int last = 100_002;
        boolean pair = false;
        int width = 0;
        for(int i=0;i<N;i++) {
            if(last-arr[i]<=1) {
                pair = !pair;
                if(!pair) {
                    answer += (long) width * arr[i];
                } else {
                    width = arr[i];
                }
                last = 100_002;
            } else {
                last = arr[i];
            }
        }

        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
여러 직사각형을 만들어도 된다.
막대를 전부 사용하지 않아도 된다.
막대의 길이를 1만 줄일수 있다.
 */