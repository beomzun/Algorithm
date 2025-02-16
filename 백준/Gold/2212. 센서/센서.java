import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        if(K>=N) {
            System.out.println(0);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensors = new int[N];
        for(int i=0;i<N;i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        int[] dis = new int[N-1];
        for(int i=0;i<N-1;i++) {
            dis[i] = sensors[i+1]-sensors[i];
        }
        Arrays.sort(dis);
        int answer = 0;
        for (int i = 0; i < N-1-(K-1); i++) {
            answer += dis[i];
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
1 3 6 6 7 9
집중국 두개
거리 - 2,3,1,2 => 집중국이 두개이므로 하나 생략


3 6 7 8 10 12 14 15 18 20
다섯개
거리 - 3 1 1 2 2 2 1 3 2 => 집중국이 5개므로 4개 생략
3 / 6 7 8 10 12 / 14 15 / 18 / 20
 */