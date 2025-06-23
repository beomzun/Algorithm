import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        for(int i=0;i<3;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                s = s.concat(st.nextToken());
            }
        }

        Set<String> set = new HashSet<>();
        set.add(s);
        String answer = "123456780";
        if (answer.equals(s)) {
            System.out.println(0);
            return;
        }
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};

        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        int time = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                String now = q.remove();
                int y = -1;
                int x = -1;
                for(int i=0;i<9;i++) {
                    if (now.charAt(i) == '0') {
                        y = i/3;
                        x = i%3;
                        break;
                    }
                }
                for(int i=0;i<4;i++) {
                    int nY = y + dy[i];
                    int nX = x + dx[i];
                    if(nY<0||nY>2||nX<0||nX>2) {
                        continue;
                    }

                    char[] nextArr = now.toCharArray();
                    int baseIdx = y * 3 + x;
                    int swapIdx = nY * 3 + nX;
                    nextArr[swapIdx] = now.charAt(baseIdx);
                    nextArr[baseIdx] = now.charAt(swapIdx);
                    String next = new String(nextArr);

                    if(set.contains(next)) {
                        continue;
                    }
                    if(next.equals(answer)) {
                        System.out.println(time);
                        return;
                    }
                    q.add(next);
                    set.add(next);
                }
            }
            time++;
        }

        System.out.println(-1);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
9! = 360,000 ~
이차원배열이 아닌 하나의 문자열로 관리. bfs로 완탐.
왜 문자배열이 아닌가? set 비교 불가
 */