import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int overCount = Integer.parseInt(st.nextToken());
            int j=0;
            while(j<N && arr[j]!=0) {
                j++;
            }
            while(overCount>0) {
                if(arr[j]==0) {
                    overCount--;
                }
                j++;
            }
            while(j<N && arr[j]!=0) {
                j++;
            }
            arr[j] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int val : arr) {
            sb.append(val).append(" ");
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
4
2 1 1 0
1 : 내 왼쪽에 두명+나보다 작은놈수 = 오른쪽에 한명 _ _ 1 _
2 : 내 왼쪽에 하나+나보다 작은놈수 = 오른쪽에 하나 _ 2 _ _ / _ _ 2 _ => _21_
3 : 내 왼쪽에 하나+나보다 작은놈수 = 오른쪽에 없음
4 : 왼쪽에 없음 = 오른쪽에 세명
 */