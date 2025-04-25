import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitCounts = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            visitCounts[i] = visitCounts[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i=N;i>X;i--) {
            visitCounts[i] -= visitCounts[i-X];
        }

        int max = 0;
        int maxCount = 0;
        for(int i=1;i<=N;i++) {
            if(visitCounts[i]>max) {
                max = visitCounts[i];
                maxCount=1;
                continue;
            }
            if(visitCounts[i]==max) {
                maxCount++;
            }
        }
        if(max==0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max+"\n"+maxCount);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
블로그 운영 N일
X일 동안 가장 많이 들어온 방문자 수와 그 기간
 */