import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] routers = new int[N];
        for (int i = 0; i < N; i++) {
            routers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(routers);

        int low = 1;
        int high = routers[N - 1] - routers[0] + 1;
        while (low < high) {
            int distance = (low + high) / 2;
            int count=1;
            int lastLocation = routers[0];
            for (int i = 1; i < N; i++) {
                if (routers[i] - lastLocation >= distance) {
                    count++;
                    lastLocation = routers[i];
                }
            }
            if (count >= C) {
                low = distance + 1;
            } else {
                high = distance;
            }
        }
        System.out.println(low - 1);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
우선순위큐와 트리맵으로 모든 위치에서의 다음집과의 거리를 기준으로 하나씩 제거하려는 방법이었음.
---
이분탐색 문제들에 대해 이분탐색을 제대로 적용하지 않고 맵을 자주 사용하는 습관이 있음.
각 거리에 대해 해당 거리일 때 가능한 공유기수를 파악하는 방법 -> 거리에 대해 이분탐색으로 조절하는 방법임
 */