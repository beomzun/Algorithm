import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static ArrayList<Integer>[] friends;
    static boolean[] visit;
    static int min = 50;
    static ArrayList<Integer> king;

    public void solution() throws IOException {
        input();

        king = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        out();
    }
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        friends = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1) {
                break;
            }
            friends[a].add(b);
            friends[b].add(a);
        }
    }

    public void bfs(int val) {
        visit = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        visit[val] = true;
        q.add(val);

        int rest = N - 1;
        int time = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.remove();
                for (int j : friends[now]) {
                    if (!visit[j]) {
                        rest--;
                        visit[j] = true;
                        q.add(j);
                    }
                }
            }
            if (rest == 0) {
                break;
            }
            time++;
        }
        if (time == min) {
            king.add(val);
            return;
        }
        if (time < min) {
            min = time;
            king = new ArrayList<>();
            king.add(val);
        }
    }

    public void out() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(min + " " + king.size() + "\n");
        for (int i : king) {
            bw.write(i + " ");
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
각 사람마다 bfs 돌면서 몇번 걸리는지 체크
min 값 저장하고 배열에 min 값에 해다하는 사람들 투입
최소 갱신될경우, 배열 초기화
 */