import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0 + "\n" + 1);
            return;
        }

        int[] visitCount = new int[100_001];
        int[] visitTime = new int[100_001];
        visitTime[N] = -1;
        visitCount[N] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        int time = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.remove();
                //방문한적이 없거나 같은 사이클에 방문
                if (now + 1 <= 100_000 && (visitCount[now + 1] == 0 || visitTime[now + 1] == time)) {
                    visitTime[now + 1] = time;
                    if (visitCount[now + 1] == 0) {
                        q.add(now + 1);
                    }
                    visitCount[now + 1] += visitCount[now];
                }
                if (now - 1 >= 0 && (visitCount[now - 1] == 0 || visitTime[now - 1] == time)) {
                    visitTime[now - 1] = time;
                    if (visitCount[now - 1] == 0) {
                        q.add(now - 1);
                    }
                    visitCount[now - 1] += visitCount[now];
                }
                if (now * 2 <= 100_000 && (visitCount[now * 2] == 0 || visitTime[now * 2] == time)) {
                    visitTime[now * 2] = time;
                    if (visitCount[now * 2] == 0) {
                        q.add(now * 2);
                    }
                    visitCount[now * 2] += visitCount[now];
                }
            }
            if (visitCount[K] != 0) {
                break;
            }
            time++;
        }
        System.out.println(time + "\n" + visitCount[K]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}