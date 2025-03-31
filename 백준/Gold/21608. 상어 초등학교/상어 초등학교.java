import java.util.*;
import java.io.*;
class Solution {
    int N;
    int[][] board;
    Set<Integer>[] friends;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        friends = new Set[N*N+1];
        for(int i=1;i<=N*N;i++) {
            friends[i] = new HashSet<>();
        }
        Queue<Integer> step = new ArrayDeque<>();
        for(int i=0;i<N*N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            step.add(num);
            for(int j=0;j<4;j++) {
                friends[num].add(Integer.parseInt(st.nextToken()));
            }
        }
        int test = N*N;
        while(test-->0) {
            int nearFriendCount=-1;
            int nearEmptyCount=-1;
            int targetR = -1;
            int targetC = -1;
            int num = step.remove();
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(board[i][j]!=0) {
                        continue;
                    }
                    int tmpFriendCount = calCount(false, i,j,num);
                    int tmpEmptyCount = calCount(true,i,j,num);
                    if(tmpFriendCount>nearFriendCount) {
                        nearFriendCount = tmpFriendCount;
                        nearEmptyCount = tmpEmptyCount;
                        targetR=i;
                        targetC=j;
                    } else if(tmpFriendCount==nearFriendCount) {
                        if(tmpEmptyCount>nearEmptyCount) {
                            nearEmptyCount = tmpEmptyCount;
                            targetR=i;
                            targetC=j;
                        }
                    }
                }
            }
            board[targetR][targetC] = num;
        }

        int[] counts = {0,1,10,100,1000};
        int answer = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int num = board[i][j];
                int count = calCount(false, i,j,num);
                answer += counts[count];
            }
        }

        System.out.println(answer);
    }
    int[] dy = {-1,0,1,0};
    int[] dx = {0,-1,0,1};
    public int calCount(boolean isEmpty, int row, int col, int num) {
        if(isEmpty) {
            int count = 0;
            for(int i=0;i<4;i++) {
                int nY = row+dy[i];
                int nX = col+dx[i];
                if(nY<0||nY>=N||nX<0||nX>=N || board[nY][nX]!=0) {
                    continue;
                }
                count++;
            }
            return count;
        }
        int count = 0;
        for(int i=0;i<4;i++) {
            int nY = row+dy[i];
            int nX = col+dx[i];
            if(nY<0||nY>=N||nX<0||nX>=N || !friends[num].contains(board[nY][nX])) {
                continue;
            }
            count++;
        }
        return count;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
인접 = 상하좌우
1. 빈 칸 중에 인접한 칸에 좋아하는 학생이 많은 칸
2. 인접한 칸 중에 빈 칸이 많은 칸
3. 행번호 작은칸 -> 열번호 작은칸
인접한 칸에 좋아하는 학생수 0,1,10,100,1000
set으로 친구관리, 큐로 후보 관리
 */