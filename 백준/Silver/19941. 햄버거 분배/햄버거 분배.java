import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        Queue<Integer> bg = new ArrayDeque<>();
        Queue<Integer> pp = new ArrayDeque<>();
        String s = br.readLine();
        for(int i=0;i<N;i++) {
            char c = s.charAt(i);
            while(!bg.isEmpty() && bg.peek()< i-K) {
                bg.remove();
            }
            while(!pp.isEmpty() && pp.peek()< i-K) {
                pp.remove();
            }
            if(c=='H') {
                if(!pp.isEmpty()) {
                    pp.remove();
                    count++;
                } else {
                    bg.add(i);
                }
            } else {
                if(!bg.isEmpty()) {
                    bg.remove();
                    count++;
                } else {
                    pp.add(i);
                }
            }
        }

        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
버거 큐, 사람 큐 사용
각 순서마다 맞는 큐에 삽입. 다른 큐에 무언가가 존재하는 경우 같이 제거.
큐 삽입 시 들어가는 인덱스도 같이 넣는데, 매번 peek 시에 K 초과인 경우 제거
 */