import java.util.*;
import java.io.*;
class Solution {
    int[] parent;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //점 개수
        int M = Integer.parseInt(st.nextToken());   //차례 수
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!union(a, b)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }
    public int find(int n) {
        int pN = parent[n];
        if (pN == n) {
            return n;
        }
        return find(pN);
    }

    public boolean union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA == pB) {
            return false;
        }
        if (pA < pB) {
            parent[pB] = pA;
        } else {
            parent[pA] = pB;
        }
        return true;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
union find 사용. 이미 해당 집합이라면 사이클 존재.
 */