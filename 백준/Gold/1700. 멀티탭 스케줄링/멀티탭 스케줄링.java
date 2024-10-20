import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int val = Integer.parseInt(st.nextToken());
            items.add(val);
        }

        Set<Integer> tapSet = new HashSet<>();
        int outCount = 0;
        for (int i = 0; i < K; i++) {
            //이미 꽃혀있거나 꽂을수 있으면 패스
            if (tapSet.contains(items.get(i)) || (tapSet.size() < N && tapSet.add(items.get(i)))) {
                continue;
            }

            //꽂혀있는 녀석 중 안사용되는 녀석 || 가장 늦게 사용되는 녀석 제거
            int outIdx = -1;
            int outVal = -1;
            List<Integer> tmpList = items.subList(i + 1, K);
            for (int val : tapSet) {
                if (!tmpList.contains(val)) {
                    outVal = val;
                    break;
                } else {
                    if (tmpList.indexOf(val) > outIdx) {
                        outIdx = tmpList.indexOf(val);
                        outVal = val;
                    }
                }
            }
            tapSet.remove(outVal);
            tapSet.add(items.get(i));
            outCount++;
        }

        System.out.println(outCount);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
미래에 쓸 기구들 중 가장 늦게||쓰지 않을 기구 제거
---
7 20
9 10 2 9 4 6 20 18// 19 3 5 1 4 5 7 11 13 2 8 12
9 10 2 9 4 6 20 18//
---
새로운 기구 발생 시 그 때부터 N개씩 묶어서 탐색 -> 실패
3 13
2 3 4 2 3 4 1 5 5 5 2 3 2
---
그리디->현재에서 가장 확률이 높은 선택
 */
