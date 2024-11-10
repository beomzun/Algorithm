import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> LIS = new ArrayList<>();
        LIS.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val > LIS.get(LIS.size() - 1)) {
                LIS.add(val);
                continue;
            }
            int left = 1;
            int right = LIS.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (val == LIS.get(mid)) {
                    left = mid;
                    break;
                }
                if (val > LIS.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            LIS.set(left, val);
        }
        System.out.println(LIS.size() - 1);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
이전의 유사한 문제에서 N^2 방법으로 해결하였으나 배열 크기가 커져서 어려움.
---
우리가 구하는 것은 길이!!! 이다. 안의 값이 정확히 어떤 것인지는 중요하지 않다.
여기서 *대치*를 사용하였음. 10 20 30 15일 때 실제는 10 20 30 이 LIS 이지만 10 15 30으로 20을 15로 대치하여도 길이는 유사하고, 후에 더 많은 수가 포함될 수 있도록 하는 기법? 이라고 이해하면 될 것 같다.
 */