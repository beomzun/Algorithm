import java.util.*;
import java.io.*;
class Solution {
    static char[][] room = new char[5][5];  //전체 자리
    static int[] seat = new int[7];     //7개의 자리에 대한 자리번호 인덱스
    static boolean[] check = new boolean[7];    //bfs를 위한 seat번호 인덱스
    static int result = 0;
    static int count = 0;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                room[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < 19; i++) {
            comb(i, 0, 0);
        }

        System.out.println(result);
    }

    public void comb(int start, int seat_count, int y) {
        seat[seat_count] = start;
        y = room[start / 5][start % 5] == 'Y' ? y + 1 : y;
        if (y > 3) {
            return;
        }

        if (seat_count == 6) {
            count = 0;
            Arrays.fill(check, false);

            bfs(0);
            return;
        }

        for (int i = start + 1; i < 25; i++) {
            comb(i, seat_count + 1, y);
        }
    }

    public void bfs(int start) {
        check[start] = true;
        if (count == 6) {
            result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nowY = seat[start] / 5 + dy[i];
            int nowX = seat[start] % 5 + dx[i];
            if (nowY < 0 || nowY >= 5 || nowX < 0 || nowX >= 5) {
                continue;
            }

            int nowSeat = nowY * 5 + nowX;
            for (int j = 0; j < 7; j++) {
                if (seat[j] == nowSeat && !check[j]) {
                    count++;
                    bfs(j);
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
입력
'S'(이다‘솜’파의 학생을 나타냄) 또는 'Y'(임도‘연’파의 학생을 나타냄)을 값으로 갖는 5*5 행렬이 공백 없이 첫째 줄부터 다섯 줄에 걸쳐 주어진다.

과정
총 25명의 여학생들로 이루어진 여학생반은 5×5의 정사각형 격자 형태로 자리가 배치되었고, 얼마 지나지 않아 이다솜과 임도연이라는 두 학생이 두각을 나타내며 다른 학생들을 휘어잡기 시작했다.
곧 모든 여학생이 ‘이다솜파’와 ‘임도연파’의 두 파로 갈라지게 되었으며, 얼마 지나지 않아 ‘임도연파’가 세력을 확장시키며 ‘이다솜파’를 위협하기 시작했다.
위기의식을 느낀 ‘이다솜파’의 학생들은 과감히 현재의 체제를 포기하고, ‘소문난 칠공주’를 결성하는 것이 유일한 생존 수단임을 깨달았다. ‘소문난 칠공주’는 다음과 같은 규칙을 만족해야 한다.
    이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
    강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
    화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
    그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
    여학생반의 자리 배치도가 주어졌을 때, ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.

출력
첫째 줄에 ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 출력한다.

해결
bfs는 생각했으나 중복을 어떻게 제외시킬지 떠올리지 못함
---
자리가 25개로 한정되어있으니 7개의 자리를 먼저 뽑은 뒤 다솜파인원수나 연결여부를 확인하자.
---
&&조건을 ||로 쓰고, comb 재귀에서 첫번째 호출이 아닌데도 <19 조건을 걸어놔서 시간 오래 걸림
 */