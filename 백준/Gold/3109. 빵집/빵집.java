import java.util.*;
import java.io.*;
class Solution {
    int R;
    int C;
    boolean[][] visit;
    int answer = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit = new boolean[R][C];
        for(int i=-0;i<R;i++) {
            String s = br.readLine();
            for(int j=0;j<C;j++) {
                visit[i][j] = s.charAt(j)=='x';
            }
        }

        //끝까지 갔다면 적용. 아니면 리셋
        for(int i=0;i<R;i++) {
            dfs(i,0);
        }

        System.out.println(answer);
    }
    public boolean dfs(int nowR, int nowC) {
        if(nowC==C-1) {
            answer++;
            return true;
        }

        int nX = nowC+1;
        for(int i=-1;i<=1;i++) {
            int nY = nowR+i;
            if(nY>=0 && nY<R && !visit[nY][nX]) {
                visit[nY][nX] = true;
                if(dfs(nY,nX)) {
                    return true;
                }
//                visit[nY][nX] = false;
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
0열은 옆집 가스관 \ C-1 열은 웅이네 가스관
1시 3시 5시로 연결 가능. 건물이 있으면 파이프설치불가
파이프가 겹치지 않게 가장 많이 훔칠수있는 라인 수
각 열마다 dfs.
- 끝열에 도착할 경우 return true;
- false 응답 시 다음 방향 시작. 세 방향 모두 실패 시 false.
false 응답 전 배열 복구.
true 받으면 그대로 0열까지 리턴. 다음행 시작
---
시간 초과
- 오히려 실패한 곳은 다시 못가게 막아놔야되나..?
 */