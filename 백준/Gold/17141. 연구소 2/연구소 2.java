import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int virusNum;    //바이러스 발생 수
    static int virusCount = 0;  //가능 바이러스 수
    static int[][] room;    //원본 연구소
    ArrayList<int[]> viruses = new ArrayList<>();
    static int[][][] virusCandidate;    //K번째 바이러스를 적용했을 때의 연구소 결과 [k][][]
    static int[] fixVirus;
    static int min = 100;
    static int BLOCK = -1;
    static int NOTVISIT = -2;

    public void solution() throws IOException {
        input();
        spreadEachOne();
        //조합
        combination(0, 0);
        //출력
        System.out.println(min = min == 100 ? -1 : min);
    }

    public void combination(int depth, int now) {
        //모든 칸 합체
        if (depth == virusNum) {
            updateMin();
            return;
        }

        for (int i = now; i < virusCount; i++) {
            fixVirus[depth] = i;
            combination(depth + 1, i + 1);
        }
    }

    public void updateMin() {
        //현재 조합에서의 최소시간
        int totalMin = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[i][j] == BLOCK) {
                    continue;
                }

                //해당 칸에서의 최소시간
                int tmpMin = 100;
                for (int k = 0; k < virusNum; k++) {
                    int val = virusCandidate[fixVirus[k]][i][j];
                    //특정 바이러스는 해당 칸에 접근하지 못할 경우
                    if (val == NOTVISIT) {
                        continue;
                    }
                    tmpMin = Math.min(tmpMin, val);
                }
                //이 조합에서 닿지 못한 칸 존재
                if (tmpMin == 100) {
                    return;
                }
                //전체 칸 중에서 가장 오랜 시간
                totalMin = Math.max(totalMin, tmpMin);
            }
        }
        //모든 칸에 도달 가능 시 전체 조합에서의 최소시간 판단
        min = Math.min(min, totalMin);
    }

    public void spreadEachOne() {
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        for (int i = 0; i < virusCount; i++) {
            Queue<int[]> q = new ArrayDeque<>();
            int time = 0;
            int[] virus = viruses.get(i);
            q.add(virus);
            virusCandidate[i][virus[0]][virus[1]] = time;
            while (!q.isEmpty()) {
                int size = q.size();
                time++;
                for (int j = 0; j < size; j++) {
                    int[] spread = q.remove();
                    int y = spread[0];
                    int x = spread[1];
                    for (int k = 0; k < 4; k++) {
                        int nY = y + dy[k];
                        int nX = x + dx[k];
                        if (isOut(nY, nX)) {
                            continue;
                        }
                        if (virusCandidate[i][nY][nX] == NOTVISIT) {
                            virusCandidate[i][nY][nX] = time;
                            q.add(new int[]{nY, nX});
                        }
                    }
                }
            }
        }
    }

    public boolean isOut(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        virusNum = Integer.parseInt(st.nextToken());
        room = new int[N][N];
        fixVirus = new int[virusNum];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) {
                    val = NOTVISIT;
                }
                if (val == 1) {
                    val = BLOCK;
                }
                if (val == 2) {
                    viruses.add(new int[]{i, j});
                    virusCount++;
                    val = NOTVISIT;
                }
                room[i][j] = val;
            }
        }

        virusCandidate = new int[virusCount][N][N];
        copyRoom();
    }
    public void copyRoom() {
        for (int i = 0; i < virusCount; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    virusCandidate[i][j][k] = room[j][k];
                }
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
모든 가능한 칸에 바이러스 하나씩 살포한 뒤, M개를 조합하여 각 칸을 최소로 설정. 시간을 해당 값으로 업데이트하며 최대로 탐색.
 */