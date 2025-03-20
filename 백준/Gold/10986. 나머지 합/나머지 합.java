import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] preSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> counts = new HashMap<>();
        long answer = 0;
        for(int i=1;i<=N;i++) {
            preSum[i] += (preSum[i - 1] + Integer.parseInt(st.nextToken()) % M) % M;
            counts.put(preSum[i], counts.getOrDefault(preSum[i], 0) + 1);   //해당 나머지(키)를 갖는 개수
            if(preSum[i]==0) {
                answer++;
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1;i<=N;i++) {
            if(set.contains(preSum[i])) {
                continue;
            }
            set.add(preSum[i]);
            int sum = counts.get(preSum[i]);
            answer += ((long) sum * (sum - 1) / 2);
        }
        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N 1,000,000
M 1,000
값하나 : 1,000,000,000

1 7 8 20 39 18 13 -> 7
합 : 1 8 16 36 75 93 106
합나머지 : 1 1 2 1 5 2 1
값나머지 : 1 0 1 6 4 4 6

같은 나머지를 갖는 애들 짝지어주기. 애초에 0이면 +1
 */