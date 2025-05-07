import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> fuels = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            fuels.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(fuels, (o1, o2) -> o1[0] - o2[0]);

        st = new StringTokenizer(br.readLine());
        int end = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int visit = 0;
        int count = 0;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        while(now<end) {
            for(;visit<N;visit++) {
                if(now >= fuels.get(visit)[0]) {
                    q.add(fuels.get(visit)[1]);
                    continue;
                }
                break;
            }
            if(q.isEmpty()) {
                System.out.println(-1);
                return;
            }
            now += q.remove();
            count++;
        }

        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
일직선의 정글이잇음.
주유소의 위치와 각 주유소에서 얻을수있는 연료의양이 주어졌을때,
최소한으로 멈추는 횟수
---
시작부터 가다가 주유소 지날때마다 우선순위큐에 지나온 주유소의 기름양 넣기.
가다가 모자라면 큐에서 하나씩 빼서쓰기. 뺀만큼 멈춘횟수
 */