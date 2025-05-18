import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //나오는시간 오름차순, 계산대번호 오름차순, id
        Queue<int[]> q = new PriorityQueue<>((o1,o2)-> {
            if(o1[0]==o2[0]) {
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });

        Queue<int[]> emptyQueue = new ArrayDeque<>();
        for(int i=0;i<K;i++) {
            emptyQueue.add(new int[]{0, i});
        }

        long answer = 0L;
        int count = 1;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(!emptyQueue.isEmpty()) {
                int[] now = emptyQueue.remove();
                q.add(new int[]{now[0] + w, now[1], id});
                continue;
            }

            //넣기전에 같은시간 다 빼고 넣기
            //넣는애는 제일 작은 번호에 들어가지만, 나올때는 큰놈부터 나옴
            Stack<Integer> stack = new Stack<>();
            int time = q.peek()[0];
            while(!q.isEmpty()) {
                if(q.peek()[0]!=time) {
                    break;
                }
                int[] counter = q.remove();
                emptyQueue.add(new int[]{time, counter[1]});
                stack.add(counter[2]);
            }
            while(!stack.isEmpty()) {
                answer += (long) stack.pop() * count++;
            }

            int[] counter = emptyQueue.remove();
            int num = counter[1];
            int outTime = counter[0] + w;
            q.add(new int[]{outTime, num, id});
        }

        while(!q.isEmpty()) {
            Stack<Integer> stack = new Stack<>();
            int time = q.peek()[0];
            while(!q.isEmpty()) {
                if(q.peek()[0]!=time) {
                    break;
                }
                int[] counter = q.remove();
                stack.add(counter[2]);
            }
            while(!stack.isEmpty()) {
                answer += (long) stack.pop() * count++;
            }
        }

        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
가장 빨리 계산을 마칠수있는 계산대
기다려야할 시간이 같을 경우 작은번호의 계산대
계산을 마친 고객의 시간이 동일한 경우 높은번호의 계산대부터 아웃
---
계산중인큐와 빈계산대 관리.
빈계산대있으면 거기로. 아니면 게산중인큐에서 제일 빠른놈 빼기
뺄 때 같이 끝나는 애들 한번에 빼야함.
근데 뺄 때 앞번호부터 빠지므로 스택으로 뒷번호부터 나오도록 관리
(계산대번호에 대한 우선순위르 뒤집어도 큐로 묶을거니까 큰 차이없을것같음)
 */