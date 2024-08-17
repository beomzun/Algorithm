import java.util.*;
import java.io.*;
class Solution {
    static int n;
    static int m;
    static int house;
    static int chicken;
    static Point[] houseList;
    static Point[] chickenList;
    static int[] result;
    static int answer = Integer.MAX_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = 0;
        houseList = new Point[2 * n];
        chicken = 0;
        chickenList = new Point[14];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    houseList[house] = new Point(i, j);
                    house++;
                }
                if (tmp == 2) {
                    chickenList[chicken] = new Point(i, j);
                    chicken++;
                }
            }
        }
        for (int i = 0; i <= chicken - m; i++) {
            dfs(0, i);
        }

        System.out.println(answer);
    }


    public void dfs(int count, int start) {
        result[count] = start;
        //m개 골랐으면 최소비교
        if (count == m - 1) {
            int sum = 0;
            for (int i = 0; i < house; i++) {
                int min = 100;
                for (int j = 0; j < m; j++) {
                    min = Math.min(min, distance(i, j));
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }

        //아직 M개 안골랐으면 다른 치킨집 선정
        for (int i = start + 1; i < chicken; i++) {
            dfs(count + 1, i);
        }
    }

    public int distance(int i, int j) {
        return Math.abs(houseList[i].row - chickenList[result[j]].row) + Math.abs(
                houseList[i].col - chickenList[result[j]].col);
    }
}
class Point {
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
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
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.
둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.
도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

과정
치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다. 각각의 집은 치킨 거리를 가지고 있다. 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.

출력
첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.

해결
전체 치킨집 중 m개 골라서 각 집과의 거리 계산하여 최소 갱신 방법
 */