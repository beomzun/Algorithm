import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int length;
    static int weight;
    static int[][] truck;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        weight = Integer.parseInt(st.nextToken());

        truck = new int[2][n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[0][i] = Integer.parseInt(st.nextToken());
            truck[1][i] = 0;
        }

        int nowWeight = 0;
        int time = 0;
        int firstTruck = 0;
        int nextTruckNum = 0;
        //마지막 트럭이 다리를 넘어가지 않았다면
        while (truck[1][n - 1] != length + 1) {
            //다음 트럭이 들어올수 있는가
            if (nextTruckNum < n) {
                //맨앞트럭이 다리를 건넌다면
                if (truck[1][firstTruck] == length) {
                    //무게 갱신
                    nowWeight -= truck[0][firstTruck];
                }
                //새로 들어오는 트럭의 무게 검사
                if (nowWeight + truck[0][nextTruckNum] <= weight) {
                    nowWeight += truck[0][nextTruckNum];
                    nextTruckNum++;
                }
            }

            //다리 건너기
            for (int i = firstTruck; i < nextTruckNum; i++) {
                truck[1][i]++;
            }

            //다리 위 트럭 번호 갱신
            if (truck[1][firstTruck] > length) {
                firstTruck++;
            }

            time++;
        }

        System.out.println(time);
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
입력 데이터는 표준입력을 사용한다. 입력은 두 줄로 이루어진다.
입력의 첫 번째 줄에는 세 개의 정수 n (1 ≤ n ≤ 1,000) , w (1 ≤ w ≤ 100) and L (10 ≤ L ≤ 1,000)이 주어지는데,
n은 다리를 건너는 트럭의 수, w는 다리의 길이, 그리고 L은 다리의 최대하중을 나타낸다.
입력의 두 번째 줄에는 n개의 정수 a1, a2, ⋯ , an (1 ≤ ai ≤ 10)가 주어지는데, ai는 i번째 트럭의 무게를 나타낸다.

과정
강을 가로지르는 하나의 차선으로 된 다리가 하나 있다. 이 다리를 n 개의 트럭이 건너가려고 한다.
트럭의 순서는 바꿀 수 없으며, 트럭의 무게는 서로 같지 않을 수 있다. 다리 위에는 단지 w 대의 트럭만 동시에 올라갈 수 있다.
다리의 길이는 w 단위길이(unit distance)이며, 각 트럭들은 하나의 단위시간(unit time)에 하나의 단위길이만큼만 이동할 수 있다고 가정한다.
동시에 다리 위에 올라가 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다.
참고로, 다리 위에 완전히 올라가지 못한 트럭의 무게는 다리 위의 트럭들의 무게의 합을 계산할 때 포함하지 않는다고 가정한다.

출력
출력은 표준출력을 사용한다. 모든 트럭들이 다리를 건너는 최단시간을 출력하라.

해결
맨 앞 트럭이 빠지는지 먼저 확인해야함.
 */