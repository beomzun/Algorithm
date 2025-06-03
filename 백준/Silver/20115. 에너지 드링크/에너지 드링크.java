import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];
        int max = -1;
        double sum = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++){
            int bottleSize = Integer.parseInt(st.nextToken());
            if(bottleSize > max) max = bottleSize;
            arr[i] = bottleSize;
        }

        for(int index : arr){
            if(max != index) sum += (double) index / 2;
        }
        sum += max;
        System.out.print(sum);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}