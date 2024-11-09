import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N * N];
        int[] CD = new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i * N + j] = A[i] + B[j];
                CD[i * N + j] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        long count = getCount(AB, CD, N);

        System.out.println(count);
    }

    private long getCount(int[] AB, int[] CD, int N) {
        long count = 0L;
        int left = 0;
        int right = CD.length - 1;
        while (left < N * N && right >= 0) {
            if (AB[left] + CD[right] == 0) {
                int lCount = 1;
                int rCount = 1;
                while (left + 1 < N * N && AB[left] == AB[left + 1]) {
                    lCount++;
                    left++;
                }
                while (right - 1 >= 0 && CD[right] == CD[right - 1]) {
                    rCount++;
                    right--;
                }
                count += (long) lCount * rCount;
                left++;
                continue;
            }
            if (AB[left] + CD[right] < 0) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
UnOrderedMap 상수가 매우 커서 생각보다 오래걸린다..?
 */