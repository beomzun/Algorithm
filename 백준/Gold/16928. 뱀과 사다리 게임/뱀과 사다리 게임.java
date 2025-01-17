import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        int[] dis = new int[101];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()) {
            int now = q.remove();
            for (int i = 1; i <= 6; i++) {
                if (now + i <= 100 && dis[now + i] > dis[now] + 1) {
                    dis[now + i] = dis[now] + 1;
                    if (!map.containsKey(now + i)) {
                        q.add(now + i);
                    }
                    if (map.containsKey(now + i) && dis[map.get(now + i)] > dis[now + i]) {
                        dis[map.get(now + i)] = dis[now + i];
                        q.add(map.get(now + i));
                    }
                }
            }
        }

        System.out.println(dis[100]);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
사다리나 뱀이 있다면 해당 칸은 큐에 넣지 말아야함. 해당 칸에 머물수없고 반드시 이동하기 때문
 */