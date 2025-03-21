import java.util.*;
import java.io.*;
class Solution {
    int N;
    int[][] forest;
    int[][] past;   //현재칸 포함해서 최대전진수
    int max = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        past = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(past[i][j]!=0) {
                    continue;
                }
                dfs(i, j, 1);
            }
        }

        System.out.println(max);
    }

    int[] dy = {-1,0,1,0};
    int[] dx = {0,-1,0,1};
    public int dfs(int row, int col, int count) {
        if(past[row][col]==0) {
            past[row][col]=1;
        }
        for(int i=0;i<4;i++) {
            int nY = row+dy[i];
            int nX = col+dx[i];
            if(nY<0||nY>=N||nX<0||nX>=N || forest[nY][nX] <= forest[row][col]) {
                continue;
            }
            if(past[nY][nX]==0) {
                past[row][col] = Math.max(past[row][col],dfs(nY, nX, count + 1) - count + 1);
            } else {
                past[row][col] = Math.max(past[row][col], past[nY][nX] + 1);
            }
        }
        max = Math.max(max, count + past[row][col] - 1);
        return count + past[row][col] - 1;  //반환값은 시작부터 최대값
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
한 지역에서 대나무 먹음. 다먹고 상하좌우 중 한곳으로 이동. 단, 이동하는 지역에 대나무가 지금 지역보다 많아야함.
최대 이동칸수
---
Dfs 단순 반복시 시간초과 -> 현재 지역을 방문했다면, 여기부터 갈수있는 방법 저장.
 */