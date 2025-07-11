import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)-> {
            if(o1[1]==o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1]-o2[1];
        }); //도착지 오름차순, 출발지 오름차순 \ 출발,도착
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a<b) {
                continue;
            }
            q.add(new int[]{a, b});
        }

        long dis = M;
        int start = 0;
        int end = 0;
        if (!q.isEmpty()) {
            int[] now = q.remove();
            start = now[0];
            end = now[1];
        }
        while(!q.isEmpty()) {
            //뺀것의 도착지가 이전의 출발지보다 작다면 합체 / 아니면 추가
            int[] now = q.remove();
            if (now[1] <= start) {
                start = Math.max(start, now[0]);
                continue;
            }
            dis += (start - end) * 2L;
            start = now[0];
            end = now[1];
        }
        dis += (start - end) * 2L;

        System.out.println(dis);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
집은 0~M번의 번호 존재. 집 사이 거리는 1km
상근이는 0번집.

역방향이 다른 역방향과 조금이라도 겹치면 합체
 */