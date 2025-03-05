import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] opposite = {0, 6, 4, 5, 2, 3, 1};
        int[][] maxVal = new int[N][7];    //row 주사위의 밑바닥이 col면 일때 최대값
        int[][] dice = new int[N][7];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //i번째 주사위에서 j번째 면의 값
            for(int j=1;j<=6;j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
            //i번째 주사위에서 밑바닥이 j면일 때
            for(int j=1;j<=6;j++) {
                int max = 0;
                for(int k=1;k<=6;k++) {
                    if(k==opposite[j] || k==j) {
                        continue;
                    }
                    max = Math.max(max, dice[i][k]);
                }
                maxVal[i][j] = max;
            }
        }

        int answer = 0;
        //시작 밑바닥이 i면 일때
        for(int i=1;i<=6;i++) {
            int sum = 0;
            int now = i;
            for(int j=0;j<N;j++) {
                sum += maxVal[j][now];
                if(j==N-1) {
                    break;
                }
                int opVal = dice[j][opposite[now]];
                for(int k=1;k<=6;k++) {
                    if (dice[j + 1][k] == opVal) {
                        now = k;
                        break;
                    }
                }
            }
            answer = Math.max(answer, sum);
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
1-6
2-4
3-5
한 면에 대해 반대면을 제외한 가장 큰것
 */