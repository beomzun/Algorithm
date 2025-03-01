import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] holes = new int[N];
        for(int i=0;i<N;i++) {
            holes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(holes);

        int count = 0;
        int start = holes[0];
        for(int i=1;i<N;i++) {
            int next = holes[i];
            if(next-start+1<=L) {
                continue;
            }
            count++;
            start = next;
        }
        count++;

        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
다음거까지 커버할수있으면 이어서. 아니면 다음께 새로운 시작.
 */