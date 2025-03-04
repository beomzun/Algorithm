import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int last = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            q.add(val-last);
            last = val;
        }
        for(int i=1;i<K;i++) {
            q.remove();
        }

        int answer = 0;
        while(!q.isEmpty()) {
            answer += q.remove();
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
N명을 k개의 조로 나눔
조원들은 서로 키가 인접해야함. 인원수는 달라도됌
조마다 비용은 큰놈작은놈차이

5 3
1 3 / 5 6 / 10
1 / 3 5 6 / 10
차이 : 2 2 1 4
K덩이에서 비용을 합하려면 K-1개의 값을 지울수있음.
 */