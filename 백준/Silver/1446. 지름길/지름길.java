import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        Map<Integer, Map<Integer,Integer>> paths = new HashMap<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            if(end>D) {
                continue;
            }
            if (!paths.containsKey(start)) {
                paths.put(start, new HashMap<>());
            }
            Map<Integer, Integer> tmp = paths.get(start);
            //있으면 작은거 없으면 이거
            paths.get(start).put(end, Math.min(dis, tmp.getOrDefault(end, Integer.MAX_VALUE)));
        }

        int[] distance = new int[D+1];
        for(int i=0;i<=D;i++) {
            distance[i] = i;
        }
        for(int i=0;i<D;i++) {
            distance[i+1] = Math.min(distance[i+1],distance[i]+1);
            if(paths.containsKey(i)) {
                Map<Integer, Integer> path = paths.get(i);
                for(int end : path.keySet()) {
                    distance[end] = Math.min(distance[i]+path.get(end), distance[end]);
                }
            }
        }

        System.out.println(distance[D]);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
Map -> Map
키:시작위치 / 키:끝위치 값:거리
 */