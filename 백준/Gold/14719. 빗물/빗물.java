import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] high = new int[col];
        for(int i=0;i<col;i++) {
            high[i] = Integer.parseInt(st.nextToken());
        }
        int sum=0;
        for(int i=0;i<row;i++) {
            int wide = 0;
            int start=-1;
            for(int j=0;j<col;j++) {
                if(high[j]>i) {
                    if(start!=-1) {
                        wide += j-start-1;
                    }
                    start = j;
                }
            }
            sum+=wide;
        }
        System.out.println(sum);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}