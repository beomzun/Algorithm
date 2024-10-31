import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] zip = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> planets = new ArrayList<>();
            Set<Integer> planetSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                int size = Integer.parseInt(st.nextToken());
                zip[i][j] = size;
                if (planetSet.contains(size)) {
                    continue;
                }
                planets.add(size);
                planetSet.add(size);
            }
            Collections.sort(planets);

            for (int j = 0; j < N; j++) {
                int left = 0;
                int right = N - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int midVal = planets.get(mid);
                    if (zip[i][j] == midVal) {
                        zip[i][j] = mid;
                        break;
                    }
                    if (zip[i][j] > midVal) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(zip[i], zip[j])) {
                    count++;
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
우주 최대 100개 \ 행성 최대 10000개 최소 3개
누적변화량에 대한 dp 값 계산 -> 각 행성마다 쌍 맞추기 N개의 dp값 돌면서 비교
---
좌표압축
 */