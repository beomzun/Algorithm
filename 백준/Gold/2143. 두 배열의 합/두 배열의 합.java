import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] AList = new int[N];
        Map<Integer, Integer> mapA = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        AList[0] = Integer.parseInt(st.nextToken());
        mapA.put(AList[0], 1);
        store(N, AList, st, mapA);

        int M = Integer.parseInt(br.readLine());
        int[] BList = new int[M];
        Map<Integer, Integer> mapB = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        BList[0] = Integer.parseInt(st.nextToken());
        mapB.put(BList[0], 1);
        store(M, BList, st, mapB);

        long count = 0L;
        for(int now : mapA.keySet()) {
            count += ((long) mapA.get(now) * mapB.getOrDefault(T - now, 0));
        }

        System.out.println(count);
    }

    private void store(int N, int[] List, StringTokenizer st, Map<Integer, Integer> map) {
        for (int i = 1; i < N; i++) {
            List[i] = List[i - 1] + Integer.parseInt(st.nextToken());
            map.put(List[i], map.getOrDefault(List[i], 0) + 1);
            for (int j = 0; j < i; j++) {
                int val = List[i] - List[j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
