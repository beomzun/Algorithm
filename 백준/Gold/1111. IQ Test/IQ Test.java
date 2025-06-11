import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] patterns = new int[N];
        for(int i=0;i<N;i++) {
            patterns[i] = Integer.parseInt(st.nextToken());
        }

        if(N<=2) {
            if (N == 2 && patterns[0] == patterns[1]) {
                System.out.println(patterns[0]);
                return;
            }
            System.out.println("A");
            return;
        }

        int p = patterns[0];
        int q = patterns[1];
        int r = patterns[2];
        if (p - q == 0) {
            for(int i=2;i<N;i++) {
                if (patterns[i] != p) {
                    System.out.println("B");
                    return;
                }
            }
            System.out.println(p);
            return;
        }
        
        double A = (double) (q - r) / (p - q);
        double B = q - p * A;

        if (A % 1 != 0 || B % 1 != 0) {
            System.out.println("B");
            return;
        }

        for(int i=0;i<N-1;i++) {
            if((int)(patterns[i]*A+B) != patterns[i+1]) {
                System.out.println("B");
                return;
            }
        }

        System.out.println((int)(patterns[N - 1] * A + B));
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
다음수 구하기 \ 모든답은 앞수*a + b의 규칙임. a,b는 정수
다음수가 여러개가 가능하면 A, 구할수없는경우는 B
수가 3개이상 주어진다면 값구하기
- 정수가 아닌 답이면 B
2개이하인 경우 A
- 두 수가 같으면 해당수
-12*A + B = 12
12*A + B = -36
p*A + B = q
q*A + B = r
p-q A = q-r
 */