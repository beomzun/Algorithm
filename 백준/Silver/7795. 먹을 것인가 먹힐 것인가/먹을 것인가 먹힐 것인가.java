import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int M;
    static Integer[] A;
    static Integer[] B;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new Integer[N];
            B = new Integer[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            int count = 0;
            for (int a : A) {
                int left = 0;
                int right = M - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (B[mid] < a) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += left;
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
정렬 후 N^2 시간 초과 = nlogn + n^2
---
각 b에 대해 A 이분 탐색 후 남은 사이즈 +
 */