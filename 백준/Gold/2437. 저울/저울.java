import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        for(int val : arr) {
            if(val > sum+1) {
                System.out.println(sum + 1);
                return;
            }
            sum += val;
        }
        System.out.println(sum+1);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
주어진 추들을 사용해서 측정할 수 없는 무게의 최소값.
1 1 2 3 6 7 30
누적합+1 보다 크면 누적합+1을 만들지 못함.
 */