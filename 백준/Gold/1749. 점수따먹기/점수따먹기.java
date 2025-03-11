import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + val;
            }
        }
        int max = arr[1][1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                for(int rI = i;rI<=N;rI++) {
                    for(int rJ=j;rJ<=M;rJ++) {
                        int now = arr[rI][rJ] - arr[rI][j - 1] - arr[i - 1][rJ] + arr[i - 1][j - 1];
                        max = Math.max(max,now);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N,M 200까지면 최대 40000칸인데 왜 40000C2가 풀리지..?
 */