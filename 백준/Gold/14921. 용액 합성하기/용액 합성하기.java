import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = arr[N - 1] + arr[0];
        int left = 0;
        int right = N-1;
        while(left<right) {
            int sum = arr[left]+arr[right];
            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
            }
            if(sum==0) {
                break;
            }
            if(sum>0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(min);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*

 */