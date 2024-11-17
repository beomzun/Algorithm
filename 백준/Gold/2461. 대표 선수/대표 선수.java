import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] students = new int[N][M];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                students[i][j] = val;
                map.put(val, i);
            }
            Arrays.sort(students[i]);
        }

        int max = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int val = students[i][0];
            q.add(val);
            max = Math.max(max, val);
        }
        int minDif = max - q.peek();

        while(true) {
            int power = q.remove();
            int classNum = map.get(power);
            int idx = Arrays.binarySearch(students[classNum], power);
            if (idx == M - 1) {
                break;
            }

            int newVal = students[classNum][idx + 1];
            max = Math.max(max, newVal);
            q.add(newVal);
            minDif = Math.min(minDif, max - q.peek());
        }

        System.out.println(minDif);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
3 4
12 \16 67 43
7 \17 48 68
14 \15 54 77

4 3
10 20 30 \ 10 30
40 50 60 \ 40 60
70 80 90 \ 70 90
100 110 120 \ 100 120
130 140 150 \ 130 150
 */