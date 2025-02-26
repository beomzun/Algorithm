import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] strength = new int[N*2+1];
        for(int i=1;i<=N*2;i++) {
            strength[i] = Integer.parseInt(st.nextToken());
        }

        int up = 1;
        int down = N;
        int count = 0;
        int step = 0;
        boolean[] robot = new boolean[N * 2 + 1];
        while(count<K) {
            step++;
            //회전
            down--;
            if(down==0) {
                down = N*2;
            }
            robot[down]=false;
            up--;
            if(up==0) {
                up = N*2;
            }
            //로봇 이동
            for(int i = down;i!=up;) {
                int past = i-1;
                if(i==1) {
                    past = N*2;
                }
                if(!robot[i] && robot[past] && strength[i]>0) {
                    robot[i] = true;
                    robot[past] = false;
                    strength[i]--;
                    if(strength[i]==0) {
                        count++;
                    }
                }
                i--;
                if(i==0) {
                    i=N*2;
                }
            }
            robot[down]=false;

            //로봇 탑승
            if(strength[up]>0) {
                robot[up]=true;
                strength[up]--;
                if(strength[up]==0) {
                    count++;
                }
            }
        }
        System.out.println(step);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}