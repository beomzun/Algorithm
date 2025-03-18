import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());

            ArrayList<int[]> list = new ArrayList<>();
            boolean[] visit = new boolean[N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int pX = Integer.parseInt(st.nextToken());
                int pY = Integer.parseInt(st.nextToken());
                list.add(new int[]{pX,pY});
            }

            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());
            if(isNear(sX,sY,eX,eY)) {
                sb.append("happy").append("\n");
                continue;
            }

            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{sX,sY});
            boolean v = false;
            while(!q.isEmpty()) {
                int[] now = q.remove();
                int x = now[0];
                int y = now[1];
                if(isNear(x,y,eX,eY)) {
                    sb.append("happy").append("\n");
                    v=true;
                    break;
                }
                for(int i=0;i<N;i++) {
                    if(!visit[i]) {
                        int nX = list.get(i)[0];
                        int nY = list.get(i)[1];
                        if(isNear(x,y,nX,nY)) {
                            q.add(new int[]{nX,nY});
                            visit[i] = true;
                        }
                    }
                }
            }
            if(!v) {
                sb.append("sad").append("\n");
            }
        }

        System.out.println(sb);
    }
    public boolean isNear(int sX, int sY, int eX, int eY) {
        return cal(sX,sY,eX,eY) <= 1000;
    }
    public int cal(int sX, int sY, int eX, int eY) {
        return Math.abs(eX-sX) + Math.abs(eY-sY);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
50m마다 맥주한병 마셔야함. 빈병 새병 합해서 20개 넘으면 안됨.
끝까지 갈수있으면 happy, 아니면 sad
시작-끝 가장 가까운 길로 바로 갈수있는지 -> 가장 가까운 편의점에서 사기 -> 갈수있는지 -> ...
끝지점에서 먼편의점부터 방문하도록. 단, 편의점이 현재위치보다 끝까지 가까워야함.
---
그리디가 아니라 전체탐색임. 지금보다 더 멀더라도 비이잉 둘러서 갈수있음.
 */