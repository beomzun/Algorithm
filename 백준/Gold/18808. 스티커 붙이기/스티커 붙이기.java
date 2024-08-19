import java.util.*;
import java.io.*;

class Solution {
    static int row;
    static int col;
    static int[][] notebook;
    static int[][] sticker;
    static int result;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        notebook = new int[row][col];
        int n = Integer.parseInt(st.nextToken());

        //스티커 정보
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s_row = Integer.parseInt(st.nextToken());
            int s_col = Integer.parseInt(st.nextToken());
            sticker = new int[s_row][s_col];
            int count = 0;
            for (int j = 0; j < s_row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < s_col; k++) {
                    int val = Integer.parseInt(st.nextToken());
                    sticker[j][k] = val;
                    if (val == 1) {
                        count++;
                    }
                }
            }
            //스티커 붙이기
            for (int j = 0; j < 4; j++) {
                //붙여보기
                if (patch(sticker.length, sticker[0].length, count) || j==3) {
                    break;
                }
                //돌리기
                sticker = rotate(sticker);
            }
        }

        System.out.println(result);
    }

    public boolean patch(int s_row, int s_col, int count) {
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < col; k++) {
                int tmp_count = 0;
                for (int l = 0; l < s_row; l++) {
                    for (int m = 0; m < s_col; m++) {
                        if (j + l >= row || k + m >= col) {
                            continue;
                        }
                        if (sticker[l][m] == 1 && notebook[j+l][k+m] == 0) {
                            tmp_count++;
                        }
                    }
                }
                if (tmp_count == count) {
                    for (int l = 0; l < s_row; l++) {
                        for (int m = 0; m < s_col; m++) {
                            if (sticker[l][m] == 1) {
                                notebook[j + l][k + m] = 1;
                            }
                        }
                    }
                    result += count;
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] rotate(int[][] now) {
        int[][] next = new int[now[0].length][now.length];
        int next_x = now.length;
        for (int i = 0; i < now.length; i++) {
            next_x--;
            for (int j = 0; j < now[0].length; j++) {
                next[j][next_x] = now[i][j];
            }
        }

        return next;
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
첫째 줄에 노트북의 세로와 가로 길이를 나타내는 N(1 ≤ N ≤ 40)과 M(1 ≤ M ≤ 40), 그리고 스티커의 개수 K(1 ≤ K ≤ 100)이 한 칸의 빈칸을 사이에 두고 주어진다.
그 다음 줄부터는 K개의 스티커들에 대한 정보가 주어진다. 각 스티커는 아래와 같은 형식으로 주어진다.
먼저 i번째 스티커가 인쇄된 모눈종이의 행의 개수와 열의 개수를 나타내는 Ri(1 ≤ Ri ≤ 10)와 Ci(1 ≤ Ci ≤ 10)가 한 칸의 빈칸을 사이에 두고 주어진다.
다음 Ri개의 줄에는 각 줄마다 모눈종이의 각 행을 나타내는 Ci개의 정수가 한 개의 빈칸을 사이에 두고 주어진다. 각 칸에 들어가는 값은 0, 1이다. 0은 스티커가 붙지 않은 칸을, 1은 스티커가 붙은 칸을 의미한다.
구체적으로 스티커의 각 칸은 상하좌우로 모두 연결되어 있고, 모눈종이의 크기는 스티커의 크기에 꼭 맞아서 상하좌우에 스티커에 전혀 포함되지 않는 불필요한 행이나 열이 존재하지 않는다.

과정
스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다. 혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다. 가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.

출력
첫째 줄에 주어진 스티커들을 차례대로 붙였을 때 노트북에서 스티커가 붙은 칸의 수를 출력한다.

해결
브루트포스
각 스티커 정보를 입력받은 후 붙일수 있을때까지 위치 이동. 끝까지 못 붙이면 회전에서 처음부터 다시 위치 이동 
 */