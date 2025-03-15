import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int K = Integer.parseInt(br.readLine());
        int max = 0;
        for(String s : map.keySet()) {
            int offCount=0;
            for(int i=0;i<M;i++) {
                if(s.charAt(i)=='0') {
                    offCount++;
                }
            }
            if(K<offCount) {
                continue;
            }
            int count = map.get(s);
            if(offCount%2==0 && K%2==0) {
                max = Math.max(max, count);
                continue;
            }
            if(offCount%2==1 && K%2==1) {
                max = Math.max(max, count);
            }
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
램프 0/1 켜짐
스위치로 열 전체의 램프 상태 변경
K번 스위치를 눌렀을 때, 행 전체가 켜져있는 최대값
똑같이 생긴 행이 최대 몇개인가(없으면 하나) -> 꺼져있는 전구가 몇개인가 -> K번째에 이들이 커져있는상태가 될수있는가
 */