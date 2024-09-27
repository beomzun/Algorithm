import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 전체 역 수
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int K = Integer.parseInt(st.nextToken());   // 튜브 하나가 연결하는 역의 수
        int M = Integer.parseInt(st.nextToken());   // 하이퍼튜브 개수
        boolean[] visitStation = new boolean[N + 1];
        boolean[] visitHyperTube = new boolean[M + 1];

        // 각 역이 몇 번 하이퍼튜브에 속해있는지
        ArrayList<Integer>[] stations = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            stations[i] = new ArrayList<>();
        }
        // 각 하이퍼튜브가 몇 번 역들을 연결하는지
        ArrayList<Integer>[] hyperTubes = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) {
            hyperTubes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int val = Integer.parseInt(st.nextToken());
                hyperTubes[i].add(val);
                stations[val].add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visitStation[1] = true;
        int time = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.remove();
                // 현재 역이 속한 하이퍼튜브
                for (int tube : stations[now]) {
                    if (visitHyperTube[tube]) {
                        continue;
                    }
                    visitHyperTube[tube] = true;
                    // 이 하이퍼튜브에서 갈 수 있는 역들
                    for (int station : hyperTubes[tube]) {
                        if (visitStation[station]) {
                            continue;
                        }
                        if (station == N) {
                            System.out.println(time + 1);
                            return;
                        }
                        visitStation[station] = true;
                        q.add(station);
                    }
                }
            }
            time++;
        }

        System.out.println(-1);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
하이퍼튜브에 어떤 역이 있는지
각 역이 어떤 하이퍼튜브에 연결되어있는지
 */