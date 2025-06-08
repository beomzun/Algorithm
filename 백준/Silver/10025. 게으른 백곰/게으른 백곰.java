import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] ice = new long[N];
        int[] pos = new int[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            long g = Long.parseLong(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[i] = g;
            pos[i] = x;
        }

        //위치에 따른 인덱스 오름차순 배열
        Integer[] idx = new Integer[N];
        for(int i=0;i<N;i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (o1, o2) -> pos[o1] - pos[o2]);

        long sum = 0L;
        int left = 0;
        long max = 0L;
        for(int right=0;right<N;right++) {
            sum += ice[idx[right]];
            while(pos[idx[right]] - pos[idx[left]] > 2*K) {
                sum -= ice[idx[left]];
                left++;
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
얼음양동이 N개, K만큼 확보 가능
N개의 줄에 얼음의 양과 좌표 주어짐.
한 위치에서 확보할수잇는 최대 얼음 구하기
---
슬라이딩윈도우
 */