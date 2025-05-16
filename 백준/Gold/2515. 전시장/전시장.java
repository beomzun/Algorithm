import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new int[]{len, cost});
        }
        list.sort((o1, o2) -> {
            if(o1[0]==o2[0]) {
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });

        int max = 0;
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        for(int[] now : list) {
            if(dp.floorKey(now[0]-S)==null) {
                max = Math.max(max, now[1]);
                dp.put(now[0], max);
                continue;
            }
            max = Math.max(max, dp.get(dp.floorKey(now[0]-S)) + now[1]) ;
            dp.put(now[0], max);
        }

        int answer = 0;
        for(int key : dp.keySet()) {
            answer = Math.max(answer, dp.get(key));
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
그림을 겹쳐서 보이게 할 때 S길이 이상 노출된 그림의 가격의 합
- 비싼게 잘보이도록.
6 4
8 230
    10 100
17 200
    15 80
    20 75
26 80
제한이 4 & 20-10 23-12 26-11 이럴때 23이 제일 비싸니까 고정하면 나머지 둘을 버리게됨.
---
길이순으로 정렬
-> 트리셋 사용해서 내 길이-S 보다 작거나 같은 길이에서의 최대값+내값
=> 트리dp
 */