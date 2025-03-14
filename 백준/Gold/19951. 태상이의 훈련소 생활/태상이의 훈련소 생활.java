import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[N+1];
        for(int i=1;i<=N;i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int[] preSum = new int[N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            preSum[a] += k;
            if(b<N) {
                preSum[b+1] -= k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            preSum[i] += preSum[i-1];
            heights[i] += preSum[i];
            sb.append(heights[i]).append(" ");
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
1 5 -3
여기부터 해! (1) 에서 -3 기록
여기까지 해! (5) 다음칸에 +3 복구
지시에 포함되지 않는 칸들은 0일 것임.
조교들의 지시를 누적합으로 진행 후 base에 적용. 합 출력
 */