import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> base = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            base.add(new int[]{num,start,end});
        }
        int max = 0;
        int[] answer = new int[N+1];
        //끝시간 정렬 / 끝시간,방번호,강의번호
        Queue<int[]> q = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        Queue<Integer> room = new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
            int[] lecture = base.remove();
            if(q.isEmpty()) {
                q.add(new int[]{lecture[2],1,lecture[0]});
                max = Math.max(max,1);
                answer[lecture[0]] = 1;
                continue;
            }
            while(true) {
                if(!q.isEmpty() && q.peek()[0] <= lecture[1]) {
                    int roomNum = q.remove()[1];
                    room.add(roomNum);
                    continue;
                }
                break;
            }
            int roomNum = max+1;
            if(!room.isEmpty()) {
                roomNum = room.remove();
            }
            answer[lecture[0]] = roomNum;
            q.add(new int[]{lecture[2],roomNum,lecture[0]});
            max = Math.max(max, q.size());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        for(int i=1;i<=N;i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}