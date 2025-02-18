import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int[] answer = new int[N];
            int left = 0;
            int right = N-1;
            int idx=0;
            while(idx<N) {
                answer[left++] = arr[idx++];
                if(idx==N) {
                    break;
                }
                answer[right--] = arr[idx++];
            }
            int max = 0;
            for(int i=0;i<N-1;i++) {
                max = Math.max(max, Math.abs(answer[i]-answer[i+1]));
            }
            max = Math.max(max, answer[N-1]-answer[0]);

            sb.append(max).append("\n");
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
