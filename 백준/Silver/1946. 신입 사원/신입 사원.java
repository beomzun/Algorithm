import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());

            int[] apply = new int[N];
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken()) - 1;
                int talk = Integer.parseInt(st.nextToken()) - 1;
                apply[paper] = talk;
            }

            //2순위부터 뽑히려면 자기앞의 순위보다 다른 순위가 높아야함.
            int minTalk = apply[0];
            int count = 1;
            for(int i=1;i<N;i++) {
                if(apply[i]<minTalk) {
                    count++;
                    minTalk = apply[i];
                }
            }
            sb.append(count).append("\n");
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
다른 모든 지원자와 비교했을 때 두 성적순위 중 하나가 다른 지원자보다 떨어지지 않는 경우 선발
서류에서 나보다 뛰어난 사람 중에 면접도 나보다 뛰어난 사람이 있는지
걍 전체 비교 n^2
1순위들 제외 -> 2순위들부터 시작. 2순위부터 뽑히기 위해서는 자기 앞의 애들보다 다른 성적이 뛰어나야함. 즉, 서류를 기준으로 하면 면접은 1순위보다 잘봤어야함
0804-0902
 */