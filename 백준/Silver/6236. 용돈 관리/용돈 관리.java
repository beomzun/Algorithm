import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int left = 0;
        int right = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while(left<right) {
            int K = (left + right) / 2;
            int count = 0;
            int now = 0;
            for(int i=0;i<N;i++) {
                if (now < arr[i]) {
                    now = K;
                    count++;
                }
                now -= arr[i];
                if(count>M) {
                    break;
                }
            }
            if (count <= M) {
                right = K;
            } else {
                left = K + 1;
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
/*
N일 동안 사용할 금액, M번만 인출함.
K원을 인출하고, 해당 돈으로 하루를 보낼수있으면 그대로 사용, 모자라면 통장에 집어넣고 다시 K원 인출.
정확히 M번을 맞추기위한 K
1_000_000_000 로그화 -> 30 * N
 */