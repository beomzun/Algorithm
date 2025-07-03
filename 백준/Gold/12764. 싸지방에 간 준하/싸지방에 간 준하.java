import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] pc =  new int[N][2];    //각 pc는 하나의 행임. 시작, 종료
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pc[i][0] = Integer.parseInt(st.nextToken());
            pc[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pc, (o1, o2) -> {
            return o1[0]-o2[0];
        });

        PriorityQueue<int[]> pcs = new PriorityQueue<>((o1,o2)-> {
            return o1[0] - o2[0];
        });   //종료시간, 좌석번호

        int count=0;
        PriorityQueue<Integer> seats = new PriorityQueue<>();

        int[] seatCount = new int[N + 1];
        for(int i=0;i<N;i++) {
            //기존 pc들 중에 끝난시간이 있으면 제거 & 넣을때 빈자리없으면 새 자리 생성
            while (!pcs.isEmpty() && pcs.peek()[0] < pc[i][0]) {
                seats.add(pcs.remove()[1]);
            }

            int nowSeat;
            if(seats.isEmpty()) {
                nowSeat = ++count;
            } else {
                nowSeat = seats.remove();
            }
            seatCount[nowSeat]++;

            pcs.add(new int[]{pc[i][1], nowSeat});
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for (int i = 1; i<=N && seatCount[i] != 0; i++) {
            sb.append(seatCount[i]).append(" ");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
컴퓨터 사용률에 따라 다른 성능의 컴퓨터 설치
모든 사람은 항상 정해진 시간에 싸지방에 다닌다.
싸지방에 입장했을때 남은 자리중 가장 번호가 작은 번호에 앉는다.
모든 사람이 기다리지 않고 싸지방을 이용할수있는 컴퓨터의 최소 개수와 / 이 경우 자리별로 몇명의 사람이 사용하는가
---
사람수 1~100_000
전체자리수 K. 남은자리에 대한 PQ. q가 비었으면 새로운 번호 사용.
정렬 -> 시작시간순으로 PQ에 도착시간과 자리번호를 삽입. 각 삽입시 peek해서 끝난시간 제외(이 때 자리 반납시 자리q에 삽입)
자리별 사용횟수는 int배열 사용. 출력시에는 0이 아닐때까지.
 */