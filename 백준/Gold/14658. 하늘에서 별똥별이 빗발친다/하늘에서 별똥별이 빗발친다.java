import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //지구 가로길이
        int M = Integer.parseInt(st.nextToken());   //지구 세로길이
        int L = Integer.parseInt(st.nextToken());   //트램펄린 길이
        int K = Integer.parseInt(st.nextToken());   //별똥별 수
        if(K==1) {
            System.out.println(0);
            return;
        }
        
        TreeMap<Integer, TreeSet<Integer>> stars = new TreeMap<>(); //x,y
        ArrayList<int[]> starList = new ArrayList<>();
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            starList.add(new int[]{x, y});
            if (!stars.containsKey(x)) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(y);
                stars.put(x, set);
            } else {
                stars.get(x).add(y);
            }
        }
        Collections.sort(starList, (o1,o2)-> {
            if(o1[0]==o2[0]) {
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });

        int bounce = 0;
        for(int i=0;i<K;i++) {
            int[] s1 = starList.get(i);
            for(int j=i+1;j<K;j++) {
                int[] s2 = starList.get(j);

                int count = 0;
                int tX = Math.min(s1[0], s2[0]);
                int tY = Math.min(s1[1], s2[1]);
                for(int sX : stars.keySet()) {
                    if(sX < tX) {
                        continue;
                    }
                    if (sX > tX + L) {
                        break;
                    }
                    for(int sY : stars.get(sX)) {
                        if(sY < tY) {
                            continue;
                        }
                        if (sY > tY + L) {
                            break;
                        }
                        count++;
                    }
                }
                bounce = Math.max(bounce, count);
            }
        }

        System.out.println(K - bounce);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
트램펄린 모서리도 허용
---
정사각형 누적합 -> 500,- * 500,- -> 시간초과
별똥별에 맞춰 트램펄린을 배치할때 -> 100 * 100
---
각 별마다 사분면으로 트램펄린 배치했으나 다이아몬드 배치시 반례
-> 별 두개 잡고 상좌 테두리 만드는 방식으로해보자
 */