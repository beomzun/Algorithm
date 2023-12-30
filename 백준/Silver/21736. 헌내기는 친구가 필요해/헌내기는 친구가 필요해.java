import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        //캠퍼스 정보
        String[][] arr = new String[y][x];
        for (int i = 0; i < y; i++) {
            arr[i] = br.readLine().split("");
        }
        //도연이 위치
        int yidx = 0;
        int xidx = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j].equals("I")) {
                    yidx = i;
                    xidx = j;
                    i=y;
                    break;
                }
            }
        }
        boolean[][] visit = new boolean[y][x];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{yidx, xidx});
        visit[yidx][xidx] = true;
        int[] tmp;
        int sum = 0;
        while (!queue.isEmpty()) {
            tmp = queue.remove();
            if (arr[tmp[0]][tmp[1]].equals("P")) {
                sum++;
            }
            if (tmp[0] > 0 && !visit[tmp[0] - 1][tmp[1]] && !arr[tmp[0] - 1][tmp[1]].equals("X")) {
                visit[tmp[0] - 1][tmp[1]] = true;
                queue.add(new int[]{tmp[0] - 1, tmp[1]});
            }
            if (tmp[0] < y - 1 && !visit[tmp[0] + 1][tmp[1]] && !arr[tmp[0] + 1][tmp[1]].equals("X")) {
                visit[tmp[0] + 1][tmp[1]] = true;
                queue.add(new int[]{tmp[0] + 1, tmp[1]});
            }
            if (tmp[1] > 0 && !visit[tmp[0]][tmp[1] - 1] && !arr[tmp[0]][tmp[1] - 1].equals("X")) {
                visit[tmp[0]][tmp[1] - 1] = true;
                queue.add(new int[]{tmp[0], tmp[1] - 1});
            }
            if (tmp[1] < x - 1 && !visit[tmp[0]][tmp[1] + 1] && !arr[tmp[0]][tmp[1] + 1].equals("X")) {
                visit[tmp[0]][tmp[1] + 1] = true;
                queue.add(new int[]{tmp[0], tmp[1] + 1});
            }
        }
        if (sum == 0) {
            bw.write("TT");
        } else {
            bw.write(String.valueOf(sum));
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