import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[][] pos = new double[N][2];
        double[][] dis = new double[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            pos[i][0] = x;
            pos[i][1] = y;
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i==j) {
                    dis[i][j] = 100_000;
                    continue;
                }
                dis[i][j] = Math.sqrt(Math.pow(pos[i][0]-pos[j][0],2) + Math.pow(pos[i][1]-pos[j][1],2));
            }
        }

        boolean[] visit = new boolean[N];
        visit[0] = true;
        Queue<Edge> q = new PriorityQueue<>(Comparator.comparingDouble(e -> e.dis));
        for(int i=1;i<N;i++) {
            q.add(new Edge(i,dis[0][i]));
        }

        double answer = 0;
        int starCount = N-1;
        while(!q.isEmpty()) {
            Edge e = q.remove();
            if(visit[e.num]) {
                continue;
            }
            visit[e.num] = true;
            answer += e.dis;
            for(int j=0;j<N;j++) {
                if(j==e.num || visit[j]) {
                    continue;
                }
                q.add(new Edge(j, dis[e.num][j]));
            }
            
            starCount--;
            if(starCount==0) {
                break;
            }
        }

        System.out.printf("%.2f", answer);
    }
}
class Edge {
    int num;
    double dis;

    Edge(int num, double dis) {
        this.num = num;
        this.dis = dis;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N개의 별들이 연결되어있어야함.
소수점 잘라줘야함..
 */