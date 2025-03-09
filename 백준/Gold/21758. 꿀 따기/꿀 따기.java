import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pays = new int[N];
        int[] ascSum = new int[N];
        int[] descSum = new int[N];
        for(int i=0;i<N;i++) {
            pays[i] = Integer.parseInt(st.nextToken());
        }
        ascSum[0] = pays[0];
        descSum[N-1] = pays[N-1];
        for(int i=1;i<N;i++) {
            ascSum[i] += ascSum[i-1] + pays[i];
            descSum[N-1-i] = descSum[N-i]+pays[N-1-i];
        }
        int max = 0;
        //벌벌통
        for(int i=1;i<N-1;i++) {
            int sum = (ascSum[i - 1] - ascSum[0]) + (ascSum[N - 1] - ascSum[i]) * 2;
            max = Math.max(max,sum);
        }
        //벌통벌
        for(int i=1;i<N-1;i++) {
            int sum = ascSum[i] - ascSum[0] + descSum[i] - descSum[N - 1];
            max = Math.max(max,sum);
        }
        //통벌벌
        for(int i=1;i<N-1;i++) {
            int sum = descSum[i+1]-descSum[N-1] + (descSum[0]-descSum[i])*2;
            max = Math.max(sum, max);
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
벌 위치 두개 / 벌집 하나
벌들은 벌집으로 날아가면서 방문하는 모든위치의 꿀 획득. 벌집포함
대신 벌이 시작하는 위치에서는 획득 불가
벌벌통 - 가운데 벌 옮기기
벌통벌 - 가운데 통 옮기기
통벌벌 - 가운데 벌 옮기기
=> 세 가지 경우 모두 탐색해 최대값 추적
 */