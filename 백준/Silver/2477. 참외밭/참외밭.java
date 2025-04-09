import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int maxY = 0;
        int maxX = 0;
        int nowIdx = 0;
        int[] lens = new int[6];
        for(int i=0;i<6;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            lens[i] = len;
            if(len > maxY) {
                maxY = len;
                nowIdx = i;
            }
        }
        int rightIdx = nowIdx+1;
        int leftIdx = nowIdx-1;
        if(rightIdx==6) {
            rightIdx = 0;
        }
        if(leftIdx==-1) {
            leftIdx=5;
        }

        int dir=0;
        if(lens[rightIdx] > lens[leftIdx]) {
            dir = 1;
            maxX = lens[rightIdx];
            nowIdx = rightIdx;
        } else {
            dir = -1;
            maxX = lens[leftIdx];
            nowIdx = leftIdx;
        }

        int big = maxY * maxX;

        nowIdx+=dir;
        if(nowIdx==6) {
            nowIdx=0;
        } else if(nowIdx==-1) {
            nowIdx=5;
        }
        nowIdx+=dir;
        if(nowIdx==6) {
            nowIdx=0;
        } else if(nowIdx==-1) {
            nowIdx=5;
        }

        int small = lens[nowIdx];
        nowIdx+=dir;
        if(nowIdx==6) {
            nowIdx=0;
        } else if(nowIdx==-1) {
            nowIdx=5;
        }
        small *= lens[nowIdx];

        System.out.println((big-small)*K);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
가로 셋, 세로 셋
가장 긴 가로, 가장 긴 세로가 제일 큰 직사각형
1. 가장 긴 길이 구하기(가로)
2. 여기에 붙은 두 길이 중 긴게 세로
3. 세로에 붙은 길이(작은가로)
4. 그 옆에 붙은게 버리는세로, 그 옆에 붙은게 버리는 가로
 */