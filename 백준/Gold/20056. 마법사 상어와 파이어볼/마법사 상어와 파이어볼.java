import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<int[]>[][] room = new Queue[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                room[i][j] = new ArrayDeque<>();
            }
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());   //질량
            int s = Integer.parseInt(st.nextToken());   //속력
            int d = Integer.parseInt(st.nextToken());   //방향
            room[y][x].add(new int[]{m, s, d, i});
        }

        int[] dy = {-1,-1,0,1,1,1,0,-1};
        int[] dx = {0,1,1,1,0,-1,-1,-1};
        Set<Integer> move = new HashSet<>();
        while(K-->0) {
            //이동
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    while(!room[i][j].isEmpty() && !move.contains(room[i][j].peek()[3])) {
                        int[] fire = room[i][j].remove();
                        int d = fire[2];
                        int s = fire[1];
                        int y = (i + dy[d] * (s % N) + N) % N;
                        int x = (j + dx[d] * (s % N) + N) % N;
                        move.add(fire[3]);
                        room[y][x].add(new int[]{fire[0],s,d,fire[3]});
                    }
                }
            }
            move.clear();

            //분할
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    int size = room[i][j].size();
                    if(size<2) {
                        continue;
                    }
                    int m=0;
                    int s=0;
                    boolean pair = room[i][j].peek()[2] % 2 == 0;
                    boolean allSame = true;
                    while(!room[i][j].isEmpty()) {
                        int[] fire = room[i][j].remove();
                        m+=fire[0];
                        s+=fire[1];
                        if(allSame) {
                            boolean nP = fire[2] % 2 == 0;
                            if(pair!=nP) {
                                allSame = false;
                            }
                        }
                    }
                    m /= 5;
                    s /= size;
                    if(m==0) {
                        continue;
                    }
                    int k = allSame?0:1;
                    for(;k<8;k+=2) {
                        room[i][j].add(new int[]{m,s,k,M++});
                    }
                }
            }
        }

        int sum = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                while (!room[i][j].isEmpty()) {
                    sum +=room[i][j].remove()[0];
                }
            }
        }

        System.out.println(sum);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
M개의 파이어볼, 질량 방향 속력 존재.
1-N-1 연결
방향으로 속력만큼 이동.
모든 이동 끝난후 같은칸에 2개이상의 파이어볼 존재시 하나로 합쳐지고 4개로 나뉘어짐.
질량은 /5, 속력은 /수, 합쳐진 애들의 방향이 모두홀수or짝수면 방향은 0246 그게아니면 1357
질량이 0이면 소멸.
 */