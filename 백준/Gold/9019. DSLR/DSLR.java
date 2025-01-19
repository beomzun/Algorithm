import java.util.*;
import java.io.*;
class Solution {
    int B;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            String[] arr = new String[10000];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(A);
            arr[A] = "";
            while(!q.isEmpty()) {
                int now = q.remove();
                int d = D(now);
                if (arr[d] == null) {
                    arr[d] = arr[now].concat("D");
                    q.add(d);
                }

                int s = S(now);
                if (arr[s] == null) {
                    arr[s] = arr[now].concat("S");
                    q.add(s);
                }

                int l = L(now);
                if (arr[l] == null) {
                    arr[l] = arr[now].concat("L");
                    q.add(l);
                }

                int r = R(now);
                if (arr[r] == null) {
                    arr[r] = arr[now].concat("R");
                    q.add(r);
                }

                if (arr[B] != null) {
                    sb.append(arr[B]).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    public int D(int now) {
        return now * 2 % 10000;
    }
    public int S(int now) {
        return now == 0 ? 9999 : now - 1;
    }
    public int L(int now) {
        int left = now * 10;
        if (left >= 10000) {
            left += left / 10000;
        }
        return left % 10000;
    }
    public int R(int now) {
        int right = now / 10;
        int pre = now % 10;
        return right + pre * 1000;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}