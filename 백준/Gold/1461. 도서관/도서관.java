import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>((o1,o2)->o2-o1);
        Queue<Integer> nQ = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            int val = Integer.parseInt(st.nextToken());
            if(val>0) {
                pQ.add(val);
            } else {
                nQ.add(val);
            }
        }

        int max=0;
        if(pQ.isEmpty()) {
            max = Math.abs(nQ.peek());
        } else if(nQ.isEmpty()) {
            max = pQ.peek();
        } else {
            max = Math.max(Math.abs(nQ.peek()), pQ.peek());
        }

        int answer = 0;
        while(!pQ.isEmpty()) {
            int dis = pQ.peek();
            for(int i=0;i<M;i++) {
                if(pQ.isEmpty()) {
                   break;
                }
                pQ.remove();
            }
            answer += dis*2;
        }

        while(!nQ.isEmpty()) {
            int dis = nQ.peek();
            for(int i=0;i<M;i++) {
                if(nQ.isEmpty()) {
                    break;
                }
                nQ.remove();
            }
            answer += Math.abs(dis)*2;
        }

        answer -= max;
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
-39 -37 -29 -28 -6 2 11
22 + 12 + 58 + 39
M개씩 제외. M개의 부호가 다른경우 어차피 왕복
 */