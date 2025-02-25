import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            if(N%2==0) {
               sb.append(N/2);
            } else {
                sb.append(N/2+1);
            }
            sb.append("\n");

            StringTokenizer st = new StringTokenizer("");
            Queue<Integer> lowQ = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> highQ = new PriorityQueue<>();
            for(int i=1;i<=N;i++) {
                if((i-1)%10==0) {
                    st = new StringTokenizer(br.readLine());
                }
                int val = Integer.parseInt(st.nextToken());
                if(lowQ.isEmpty()) {
                    lowQ.add(val);
                } else if(highQ.isEmpty()) {
                    if(lowQ.peek()>=val) {
                        highQ.add(lowQ.remove());
                        lowQ.add(val);
                    } else {
                        highQ.add(val);
                    }
                } else {
                    if(lowQ.size()==highQ.size()) {
                        if(highQ.peek()>val) {
                            lowQ.add(val);
                        } else {
                            highQ.add(val);
                            lowQ.add(highQ.remove());
                        }
                    } else {
                        if(highQ.peek()<=val) {
                            highQ.add(val);
                        } else {
                            lowQ.add(val);
                            highQ.add(lowQ.remove());
                        }
                    }
                }
                if(i%2==1) {
                    sb.append(lowQ.peek()).append(" ");
                }
                if(i%20==19|| i==N) {
                    sb.append("\n");
                }
            }
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
/*
큐 두개.
큐1 : 작은애들. 내림차순으로 큰놈이 이동할수있게.
큐2 : 큰애들. 오름차순으로 작은놈이 이동할수있게.
개수 차이는 1이하로.
- 큐1보다 작다
- 큐1보다 크다 큐2보다 작다
- 큐1보다 크고 큐2보다 크다
 */