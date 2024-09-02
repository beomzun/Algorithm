import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[][] hit;
    static boolean[] base = new boolean[3];
    static int max = 0;
    static int score = 0;
    static int out = 0;
    static boolean[] visit = new boolean[9];
    static int[] order = new int[9];

    public void solution() throws IOException {
        input();
        confirm(0);
        System.out.println(max);
    }
    public void confirm(int depth) {
        if (depth == 9) {
            play();
            return;
        }
        if (depth == 3) {
            order[3] = 0;
            confirm(4);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (!visit[i]) {
                order[depth] = i;
                visit[i] = true;
                confirm(depth + 1);
                visit[i] = false;
            }
        }
    }

    public void play() {
        int idx = 0;
        int step = 0;
        score = 0;

        while (step != N) {
            out = 0;
            baseClear();
            while (out != 3) {
                int val = hit[step][order[idx]];
                if (val == 0) {
                    out++;
                } else {
                    run(val);
                }
                idx = (idx + 1) % 9;
            }
            step++;
        }
        max = Math.max(max, score);
    }

    public void run(int length) {
        if (length == 4) {
            for (int i = 0; i < 3; i++) {
                if (base[i]) {
                    score++;
                }
            }
            score++;
            baseClear();

            return;
        }

        for (int i = 0; i < length; i++) {
            if (base[2]) {
                score++;
            }
            base[2] = base[1];
            base[1] = base[0];
            base[0] = false;
        }
        base[length - 1] = true;
    }

    public void baseClear() {
        for (int i = 0; i < 3; i++) {
            base[i] = false;
        }
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        hit = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                hit[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
입력 : 이닝, 이닝 수만큼 1-9번 타자의 성적
1번 선수는 4번 타자 고정. 중간에 타순 변경 불가
1~4 / 0
출력 : 최고 득점
50이닝 -> 경우의 수 8! = 720 * 56 = 35000 * 50
---
브루트포스
---
접근 및 구현은 맞았으나 베이스간 이동을 큐로 사용하면 시간초과..배열이 정답..
 */