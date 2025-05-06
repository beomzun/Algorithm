import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b) {
                int tmp = a;
                a=b;
                b=tmp;
            }
            list.add(new int[]{a,b});
        }
        Collections.sort(list, (o1,o2)-> o1[1]-o2[1]);
        int d = Integer.parseInt(br.readLine());

        int s = 0;
        int max = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int[] line : list) {
            int start = line[0];
            int end = line[1];
            q.add(start);
            while(!q.isEmpty() && q.peek() < end - d) {
                q.remove();
            }
            max = Math.max(max, q.size());
        }

        System.out.println(max);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
사람들 정보를 둘중에 작은값의 오름차순으로 정렬
첫번째쌍의 작은수부터 철도 시작해보기.
쌍의 큰 수가 작은수+d에 포함될때까지 포함. => 큐 사이즈 측정
맨앞의 쌍 제외하고 새로운 맨앞의 쌍의 작은수+d까지 포함 -> 사이즈 갱신  ~~ max값 추출
정렬이 좀 꼬임. 넣을때는 끝이 작은애부터, 뺄때는 시작이 작은애부터
 */