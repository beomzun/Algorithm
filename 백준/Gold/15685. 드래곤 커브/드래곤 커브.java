import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static boolean[][] visit;
    static ArrayList<int[]> pastPoints = new ArrayList<>();
    static int count = 0;
    static int result = 0;
    static int lastY = 0;
    static int lastX = 0;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());
            int lineCount = (int) Math.pow(2, gen);

            pastPoints = new ArrayList<>();
            drawLine(x, y, dir, lineCount);
        }
        checkRec();

        System.out.println(result);
    }
    public void drawLine(int x, int y, int dir, int restCount) {
        //다 그렸으면 종료
        if (restCount == 1) {
            //첫 방문이면 count 증가
            if (!visit[y][x]) {
                visit[y][x] = true;
                count++;
            }
            pastPoints.add(new int[]{y, x});

            lastX = x + dx[dir];
            lastY = y + dy[dir];
            if (!visit[lastY][lastX]) {
                visit[lastY][lastX] = true;
                count++;
            }
            pastPoints.add(new int[]{lastY, lastX});

            return;
        }

        //재귀 호출
        drawLine(x, y, dir, restCount / 2);
        turnLine(lastX, lastY);
    }

    public void turnLine(int lastX, int lastY) {
        ArrayList<int[]> tmp = new ArrayList<>();

        for (int[] point : pastPoints) {
            int difY = lastX - point[1];
            int difX = lastY - point[0];

            //회전축인 경우
            if (difY == 0 && difX == 0) {
                continue;
            }

            int nowY = lastY - difY;
            int nowX = lastX + difX;
            if (!visit[nowY][nowX]) {
                visit[nowY][nowX] = true;
                count++;
            }
            tmp.add(new int[]{nowY, nowX});
        }

        pastPoints.addAll(tmp);
        lastInfo();
    }
    public void lastInfo() {
        int[] point = pastPoints.get(0);
        int difY = lastX - point[1];
        int difX = lastY - point[0];

        lastY -= difY;
        lastX += difX;
    }

    public void checkRec() {
        int now = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                //방문한 좌표수 count 넘을 시 종료
                if (now > count) {
                    return;
                }
                //방문 안했으면 패스
                if (!visit[i][j]) {
                    continue;
                }
                //방문 했다면
                now++;
                if (visit[i][j + 1] && visit[i + 1][j] && visit[i + 1][j + 1]) {
                    result++;
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
입력 정보 : x, y, 방향(0~3, 우상좌하), 세대
visit 배열로 방문한 좌표 탐색
재귀로 그리기 호출까지는 하였으나 내부에서 방향조정 실패
---
과거의 정보를 갖는 pastPoints를 arrayList를 통해 조회하면서 동시에 추가할때 ConcurrentModificationException 발생
-> Fail-fast 원칙 : forEach 사용시 내부에서 iterator 가 동작. 얘가 현재 컬렉션 상태 감지하여 수정이 발생하려고 하는 경우 구조적 안정성을 위해 에러 발생.
=> iterator 를 사용해 제거는 안전하게 할 수 있으나 추가는 불가 => 추가할 애들을 보관해뒀다가 끝나고 한번에 넣자.
---
2시간 걸렸는데 이유가 dy 1번 3번 인덱스값 거꾸로 쓴 것 때문..
 */