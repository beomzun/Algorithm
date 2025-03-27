import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] += arr[i - 1] + val;
        }

        int left = 1;
        int right = arr[N];
        while(left<right) {
            int mid = (left+right)/2;
            int base = 1;
            for(int i=1;i<M;i++) {
                for(int j=base;j<=N;j++) {
                    if(arr[j]-arr[base-1]<=mid) {
                        continue;
                    }
                    base = j;
                    break;
                }
            }
            if(arr[N]-arr[base-1]<=mid) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        System.out.println(right);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}