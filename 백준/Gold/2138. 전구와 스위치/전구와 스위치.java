import java.util.*;
import java.io.*;
class Solution {
    int N;
    boolean[] bulb;
    boolean[] dest;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bulb = new boolean[N];
        dest = new boolean[N];
        String base = br.readLine();
        for(int i=0;i<N;i++) {
            bulb[i] = base.charAt(i)=='1';
        }
        String target = br.readLine();
        for(int i=0;i<N;i++) {
            dest[i] = target.charAt(i)=='1';
        }
        int min = 100_001;
        int result = start();
        if(result!=-1) {
            min = Math.min(min, result);
        }
        bulb[0] = !bulb[0];
        bulb[1] = !bulb[1];
        result = start();
        if(result!=-1) {
            min = Math.min(min, result + 1);
        }

        if(min==100_001) {
            min = -1;
        }

        System.out.println(min);
    }
    public int start() {
        boolean[] now = Arrays.copyOf(bulb,N);
        int count = 0;
        for(int i=1;i<N-1;i++) {
            if(now[i-1]!=dest[i-1]) {
                count++;
                now[i-1] = !now[i-1];
                now[i] = !now[i];
                now[i+1] = !now[i+1];
            }
        }
        if(now[N-2]==dest[N-2] && now[N-1]==dest[N-1]) {
            return count;
        } else if(now[N-2]!=dest[N-2] && now[N-1]!=dest[N-1]) {
            return count + 1;
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
전구 N개
스위치 N개
2~N-1번 스위치를 누르면 자기랑 양 옆. 총 세개의 전구상태 변경
1번은 1,2번 / N번은 N,N-1번
 */