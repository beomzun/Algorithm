import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prefixSum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        prefixSum[0] = Integer.parseInt(st.nextToken());
        int start = prefixSum[0];

        int max = start;
        for (int i = 1; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            prefixSum[i] = Math.max(prefixSum[i - 1] + val, val);
            max = Math.max(max, prefixSum[i]);
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
Prefix Sum (feat. KSY)
---
전부 음수인 경우 판별 불가
-> 카데인 알고리즘
 */